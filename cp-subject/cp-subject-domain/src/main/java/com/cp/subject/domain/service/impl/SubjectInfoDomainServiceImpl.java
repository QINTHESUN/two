package com.cp.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.subject.common.entity.PageResult;
import com.cp.subject.common.entity.Result;
import com.cp.subject.common.enums.IsDeletedFlagEnum;
import com.cp.subject.common.util.IdWorkerUtil;
import com.cp.subject.common.util.LoginUtil;
import com.cp.subject.domain.bo.SubjectInfoBo;
import com.cp.subject.domain.bo.SubjectOptionBo;
import com.cp.subject.domain.convert.SubjectInfoBoConvert;
import com.cp.subject.domain.handler.subject.SubjectTypeHandler;
import com.cp.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.cp.subject.domain.redis.RedisUtil;
import com.cp.subject.domain.service.SubjectInfoDomainService;
import com.cp.subject.domain.service.SubjectLikedDomainService;
import com.cp.subject.infra.basic.entity.SubjectInfoEntity;
import com.cp.subject.infra.basic.entity.SubjectInfoEs;
import com.cp.subject.infra.basic.entity.SubjectLabelEntity;
import com.cp.subject.infra.basic.entity.SubjectMappingEntity;
import com.cp.subject.infra.basic.mapper.SubjectInfoDao;
import com.cp.subject.infra.basic.service.SubjectEsService;
import com.cp.subject.infra.basic.service.SubjectInfoService;
import com.cp.subject.infra.basic.service.SubjectLabelService;
import com.cp.subject.infra.basic.service.SubjectMappingService;
import com.cp.subject.infra.entity.UserInfo;
import com.cp.subject.infra.rpc.UserRpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.security.auth.Subject;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 题目信息表(SubjectInfo)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-22 20:09:53
 */
@Service
@Slf4j
public class SubjectInfoDomainServiceImpl  implements SubjectInfoDomainService {

    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectEsService subjectEsService;

    @Resource
    private RedisUtil redisUtil;

    private static final String RANK_KEY = "subject_rank";

    @Autowired
    private UserRpc userRpc;

    @Resource
    private SubjectLikedDomainService subjectLikedDomainService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SubjectInfoBo subjectInfoBo) {
        //插入题目信息
        SubjectInfoEntity subjectInfoEntity = SubjectInfoBoConvert.INSTANCE.convertBoToEntity(subjectInfoBo);
        subjectInfoEntity.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        try {
            subjectInfoService.save(subjectInfoEntity);
        }catch (Exception e){
            log.info("SubjectInfoDomainServiceImpl.add:{}",e.getMessage());
            throw e;//抛出异常回滚
        }
        //插入具体的题目
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfoEntity.getSubjectType());
        subjectInfoBo.setId(subjectInfoEntity.getId());
        handler.add(subjectInfoBo);

        List<Integer> categoryIds = subjectInfoBo.getCategoryIds();
        List<Integer> labelIds = subjectInfoBo.getLabelIds();
        List<SubjectMappingEntity> subjectMappingEntityList = new LinkedList<>();
        categoryIds.forEach(categoryId -> {
            labelIds.forEach(labelId -> {
                SubjectMappingEntity subjectMappingEntity = new SubjectMappingEntity();
                subjectMappingEntity.setSubjectId(subjectInfoBo.getId());
                subjectMappingEntity.setCategoryId(Long.valueOf(categoryId));
                subjectMappingEntity.setLabelId(Long.valueOf(labelId));
                subjectMappingEntityList.add(subjectMappingEntity);
            });
        });
        subjectMappingService.saveBatch(subjectMappingEntityList);

        //同步到es
        SubjectInfoEs subjectInfoEs = new SubjectInfoEs();
        subjectInfoEs.setDocId(new IdWorkerUtil(1,1,1).nextId());
        subjectInfoEs.setSubjectId(subjectInfoEntity.getId());
        subjectInfoEs.setSubjectAnswer(subjectInfoBo.getSubjectAnswer());
        subjectInfoEs.setCreateUser("Q");
        subjectInfoEs.setSubjectName(subjectInfoEntity.getSubjectName());
        subjectInfoEs.setSubjectType(subjectInfoEntity.getSubjectType());
        subjectEsService.insert(subjectInfoEs);

        //redis放入zadd计入排行榜
        redisUtil.addScore(RANK_KEY, LoginUtil.getLoginId(),1);


    }

    @Override
    public PageResult<SubjectInfoBo> getSubjectPage(SubjectInfoBo subjectInfoBo) {
        PageResult<SubjectInfoBo> boPageResult = new PageResult<>();
        boPageResult.setPageNo(subjectInfoBo.getPageNo());
        boPageResult.setPageSize(subjectInfoBo.getPageSize());
        int start = (subjectInfoBo.getPageNo() - 1) * subjectInfoBo.getPageSize();
        SubjectInfoEntity subjectInfoEntity = SubjectInfoBoConvert.INSTANCE.convertBoToEntity(subjectInfoBo);
        int count = subjectInfoService.queryCount(subjectInfoEntity,subjectInfoBo.getCategoryId(),subjectInfoBo.getLabelId());
        if (count == 0){
            return boPageResult;
        }
        List<SubjectInfoEntity> result =
                subjectInfoService.queryPage(subjectInfoEntity,subjectInfoBo.getCategoryId(),
                subjectInfoBo.getLabelId(),start,subjectInfoBo.getPageSize());
        List<SubjectInfoBo> boList = SubjectInfoBoConvert.INSTANCE.convertEntityToBoList(result);
        boPageResult.setRecords(boList);
        boPageResult.setTotal(count);
        return boPageResult;
    }

    @Override
    public SubjectInfoBo getSubjectInfo(SubjectInfoBo subjectInfoBo) {
        SubjectInfoEntity infoEntity = SubjectInfoBoConvert.INSTANCE.convertBoToEntity(subjectInfoBo);
        SubjectInfoEntity subjectInfoEntity =
                subjectInfoService.queryById(infoEntity);
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfoEntity.getSubjectType());
        SubjectOptionBo subjectOptionBo = handler.query(Math.toIntExact(subjectInfoBo.getId()));
        SubjectInfoBo infoBo = SubjectInfoBoConvert.INSTANCE.convertBo(subjectOptionBo, subjectInfoEntity);

        SubjectMappingEntity subjectMappingEntity = new SubjectMappingEntity();
        subjectMappingEntity.setSubjectId(subjectInfoEntity.getId());
        subjectMappingEntity.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectMappingEntity> subjectMappingEntityList =
                subjectMappingService.queryBySubjectId(subjectMappingEntity);
        List<Long> labelList = subjectMappingEntityList.stream().map(SubjectMappingEntity::getLabelId).collect(Collectors.toList());
        List<SubjectLabelEntity> subjectLabelEntityList =
                subjectLabelService.queryByLabelList(labelList);
        List<String> labelNameList = subjectLabelEntityList.stream().map(SubjectLabelEntity::getLabelName).collect(Collectors.toList());
        infoBo.setLabelName(labelNameList);
        infoBo.setLiked(subjectLikedDomainService.isLiked(subjectInfoBo.getId().toString(),LoginUtil.getLoginId()));
        infoBo.setLikedCount(subjectLikedDomainService.getLikedCount(subjectInfoBo.getId().toString()));
        return infoBo;
    }

    @Override
    public PageResult<SubjectInfoEs> querySubjectBySearch(SubjectInfoBo subjectInfoBo) {
        SubjectInfoEs subjectInfoEs = new SubjectInfoEs();
        subjectInfoEs.setPageNo(subjectInfoBo.getPageNo());
        subjectInfoEs.setPageSize(subjectInfoBo.getPageSize());
        subjectInfoEs.setKeyWord(subjectInfoBo.getKeyWord());
        return subjectEsService.querySubjectList(subjectInfoEs);
    }

    @Override
    public List<SubjectInfoBo> getContributeList() {
        Set<ZSetOperations.TypedTuple<String>> typedTuples =
                redisUtil.rankWithScore(RANK_KEY, 0L, 5L);
        if (log.isInfoEnabled()){
            log.info("getContributeList.typedTuples:{}", JSON.toJSONString(typedTuples));
        }
        if (CollectionUtils.isEmpty(typedTuples)){
            return Collections.emptyList();
        }
        List<SubjectInfoBo> boList = new LinkedList<>();
        typedTuples.forEach((rank -> {
            SubjectInfoBo subjectInfoBo = new SubjectInfoBo();
            subjectInfoBo.setSubjectCount(rank.getScore().intValue());
            UserInfo userInfo = userRpc.getUserInfo(rank.getValue());
            subjectInfoBo.setCreateUser(userInfo.getNickName());
            subjectInfoBo.setCreateUserAvatar(userInfo.getAvatar());
            boList.add(subjectInfoBo);
        }));
        return boList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean del(SubjectInfoBo subjectInfoBo) {
        // 转换为持久化实体对象
        SubjectInfoEntity subjectInfoEntity = SubjectInfoBoConvert.INSTANCE.convertBoToEntity(subjectInfoBo);

        // 1. 删除主表中的题目信息
        //subjectInfoService.del(subjectInfoEntity);

        // 2. 删除题目与分类/标签的映射关系
        subjectMappingService.delBySubjectId(subjectInfoEntity.getId());

        //// 3. 删除ES中的索引数据（如果已同步）
        //subjectEsService.deleteBySubjectId(subjectInfoEntity.getId());

        // 4. 清理Redis中该题目的点赞相关数据（例如：缓存的点赞状态）
        String subjectKey = "subject_liked:" + subjectInfoEntity.getId();
        redisUtil.del(subjectKey);

        // 5. 减少用户贡献榜积分
        String loginId = LoginUtil.getLoginId();
        redisUtil.addScore(RANK_KEY, loginId, -1); // 撤回贡献值

        if (log.isInfoEnabled()) {
            log.info("成功删除题目ID: {}, 登录用户: {}", subjectInfoEntity.getId(), loginId);
        }
        return subjectInfoService.del(subjectInfoEntity);
    }

}
