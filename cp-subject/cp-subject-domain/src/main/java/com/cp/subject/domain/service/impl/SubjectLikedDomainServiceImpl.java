package com.cp.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.subject.common.entity.PageResult;
import com.cp.subject.common.enums.SubjectLikedStatusTypeEnum;
import com.cp.subject.common.util.LoginUtil;
import com.cp.subject.domain.bo.SubjectLikedBo;
import com.cp.subject.domain.convert.SubjectInfoBoConvert;
import com.cp.subject.domain.convert.SubjectLikedBoConvert;
import com.cp.subject.domain.redis.RedisUtil;
import com.cp.subject.domain.service.SubjectLikedDomainService;
import com.cp.subject.infra.basic.entity.SubjectInfoEntity;
import com.cp.subject.infra.basic.entity.SubjectLikedEntity;
import com.cp.subject.infra.basic.mapper.SubjectLikedDao;
import com.cp.subject.infra.basic.service.SubjectInfoService;
import com.cp.subject.infra.basic.service.SubjectLikedService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 题目点赞表(SubjectLiked)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-31 10:34:01
 */
@Service
@Slf4j
public class SubjectLikedDomainServiceImpl implements SubjectLikedDomainService {

    @Resource
    private SubjectLikedService subjectLikedService;

    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private RedisUtil redisUtil;

    private static final String SUBJECT_LIKED_KEY = "subject.liked";

    private static final String SUBJECT_LIKED_COUNT_KEY = "subject.liked.count";

    private static final String SUBJECT_LIKED_DETAIL_KEY = "subject.liked.detail";

    @Override
    public void addLiked(SubjectLikedBo subjectLikedBo) {
        Long subjectId = subjectLikedBo.getSubjectId();
        String likeUserId = subjectLikedBo.getLikeUserId();
        Integer status = subjectLikedBo.getStatus();
        String hashKey = buildSubject(subjectId.toString(), likeUserId);
        redisUtil.putHash(SUBJECT_LIKED_KEY,hashKey,status);

        String countKey = SUBJECT_LIKED_COUNT_KEY + "." + subjectId;
        String detailKey = SUBJECT_LIKED_DETAIL_KEY + "." + subjectId + "." + likeUserId;
        if (SubjectLikedStatusTypeEnum.LIKED.getCode() == status){
            redisUtil.increment(countKey,1);
            redisUtil.set(detailKey,"1");
        }else {
            Integer count = redisUtil.getInt(countKey);
            if (Objects.isNull(count) || count <= 0){
                return;
            }
            redisUtil.increment(countKey,-1);
            redisUtil.del(detailKey);
        }
    }

    @Override
    public Boolean isLiked(String subjectId, String userId) {
        String detailKey = SUBJECT_LIKED_DETAIL_KEY + "." + subjectId + "." + userId;
        return redisUtil.exist(detailKey);
    }

    @Override
    public Integer getLikedCount(String subjectId) {
        String countKey = SUBJECT_LIKED_COUNT_KEY + "." + subjectId;
        Integer count = redisUtil.getInt(countKey);
        if (Objects.isNull(count) || count <= 0){
            return 0;
        }
        return redisUtil.getInt(countKey);
    }

    @Override
    public void syncLiked() {
        Map<Object, Object> subjectLikedMap =
                redisUtil.getHashAndDelete(SUBJECT_LIKED_KEY);
        if (log.isInfoEnabled()){
            log.info("syncLiked.subjectLikedMap:{}", JSON.toJSONString(subjectLikedMap));
        }
        if (MapUtils.isEmpty(subjectLikedMap)){
            return;
        }
        //批量同步到数据库
        List<SubjectLikedEntity> subjectLikedEntityList = new LinkedList<>();
        subjectLikedMap.forEach((key,val) -> {
            SubjectLikedEntity subjectLikedEntity = new SubjectLikedEntity();
            String[] keyArr = key.toString().split(":");
            String subjectId = keyArr[0];
            String likedUser = keyArr[1];
            subjectLikedEntity.setSubjectId(Long.valueOf(subjectId));
            subjectLikedEntity.setLikeUserId(likedUser);
            subjectLikedEntity.setStatus(Integer.valueOf(val.toString()));
            subjectLikedEntityList.add(subjectLikedEntity);
        });
        subjectLikedService.saveBatch(subjectLikedEntityList);
    }

    @Override
    public PageResult<SubjectLikedBo> getSubjectLikedPage(SubjectLikedBo subjectLikedBo) {
        PageResult<SubjectLikedBo> pageResult = new PageResult<>();
        pageResult.setPageNo(subjectLikedBo.getPageNo());
        pageResult.setPageSize(subjectLikedBo.getPageSize());
        int start = (subjectLikedBo.getPageNo() - 1) * subjectLikedBo.getPageSize();
        SubjectLikedEntity subjectLikedEntity = SubjectLikedBoConvert.INSTANCE.convertBoToEntity(subjectLikedBo);
        subjectLikedEntity.setLikeUserId(LoginUtil.getLoginId());
        int count = subjectLikedService.countByCondition(subjectLikedEntity);
        if (count == 0){
            return pageResult;
        }
        List<SubjectLikedEntity> subjectLikedList = subjectLikedService
                .queryPage(subjectLikedEntity, start, subjectLikedBo.getPageSize());
        List<SubjectLikedBo> subjectLikedBos = SubjectLikedBoConvert.INSTANCE.convertEntitiesToBos(subjectLikedList);
        subjectLikedBos.forEach(info -> {
            SubjectInfoEntity subjectInfoEntity =
                    subjectInfoService.queryName(info.getSubjectId());
            info.setSubjectName(subjectInfoEntity.getSubjectName());
        });
        pageResult.setRecords(subjectLikedBos);
        pageResult.setTotal(count);

        return pageResult;
    }

    private String buildSubject(String subjectID,String userId){
        return subjectID + ":" + userId;
    }
}
