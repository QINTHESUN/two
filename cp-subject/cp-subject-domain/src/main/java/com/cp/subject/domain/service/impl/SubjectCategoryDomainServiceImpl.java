package com.cp.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.cp.subject.common.enums.IsDeletedFlagEnum;
import com.cp.subject.domain.bo.SubjectCategoryBo;
import com.cp.subject.domain.bo.SubjectLabelBo;
import com.cp.subject.domain.convert.SubjectCategoryBoConvert;
import com.cp.subject.domain.service.SubjectCategoryDomainService;
import com.cp.subject.domain.util.CacheUtil;
import com.cp.subject.infra.basic.entity.SubjectCategoryEntity;
import com.cp.subject.infra.basic.entity.SubjectLabelEntity;
import com.cp.subject.infra.basic.entity.SubjectMappingEntity;
import com.cp.subject.infra.basic.service.SubjectCategoryService;
import com.cp.subject.infra.basic.service.SubjectLabelService;
import com.cp.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * 题目分类(SubjectCategory)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-22 02:49:43
 */
@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {
    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private ThreadPoolExecutor threadPoolExecutor;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Resource
    private CacheUtil cacheUtil;

    @Override
    public Boolean add(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategoryEntity subjectCategoryEntity = SubjectCategoryBoConvert.INSTANCE.convertBoToEntity(subjectCategoryBo);
        subjectCategoryEntity.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        return subjectCategoryService.add(subjectCategoryEntity);
    }

    @Override
    public Boolean update(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategoryEntity subjectCategoryEntity = SubjectCategoryBoConvert.INSTANCE.convertBoToEntity(subjectCategoryBo);
        return subjectCategoryService.update(subjectCategoryEntity);
    }

    @Override
    public Boolean delete(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategoryEntity subjectCategoryEntity = SubjectCategoryBoConvert.INSTANCE.convertBoToEntity(subjectCategoryBo);
        return subjectCategoryService.delete(subjectCategoryEntity);
    }

    @Override
    public List<SubjectCategoryBo> queryByType(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategoryEntity subjectCategoryEntity =
                SubjectCategoryBoConvert.INSTANCE.convertBoToEntity(subjectCategoryBo);
        List<SubjectCategoryEntity> subjectCategoryEntityList =
                subjectCategoryService.queryByType(subjectCategoryEntity);
        List<SubjectCategoryBo> subjectCategoryBoList =
                SubjectCategoryBoConvert.INSTANCE.convertEntitiesToBos(subjectCategoryEntityList);
        if (log.isInfoEnabled()){
            log.info("SubjectCategoryBo queryByType.boList:{}", JSON.toJSONString(subjectCategoryBoList));
        }
        subjectCategoryBoList.forEach(bo -> {
            int count = subjectCategoryService.queryCount(bo.getId());
            bo.setCount(count);
        });
        return subjectCategoryBoList;
    }

    @Override
    public List<SubjectCategoryBo> queryCategoryAndLabel(SubjectCategoryBo subjectCategoryBo) {
        String cacheKey = "categoryAndLabel:" + subjectCategoryBo.getId();
        List<SubjectCategoryBo> subjectCategoryBoList = cacheUtil.getResult(cacheKey,SubjectCategoryBo.class,
                (key) -> getSubjectCategoryBoList(subjectCategoryBo.getId())
                );
        return subjectCategoryBoList;

    }

    @Override
    public List<SubjectCategoryBo> queryAll(int code) {
        List<SubjectCategoryEntity> subjectCategoryEntityList =
                subjectCategoryService.queryAll(code);
        List<SubjectCategoryBo> subjectCategoryBoList = SubjectCategoryBoConvert.INSTANCE.convertEntitiesToBos(subjectCategoryEntityList);
        return subjectCategoryBoList;
    }


    private List<SubjectCategoryBo> getSubjectCategoryBoList(Long categoryId) {
        List<SubjectCategoryEntity> subjectCategoryEntityList  =
                subjectCategoryService.queryCategory(categoryId);
        if (log.isInfoEnabled()){
            log.info("SubjectCategoryBo queryCategoryAndLabel:{}", JSON.toJSONString(subjectCategoryEntityList));
        }
        List<SubjectCategoryBo> subjectCategoryBoList =
                SubjectCategoryBoConvert.INSTANCE.convertEntitiesToBos(subjectCategoryEntityList);
        Map<Long,List<SubjectLabelBo>> map = new HashMap<>();
        List<CompletableFuture<Map<Long,List<SubjectLabelBo>>>> completableFutureList
                = subjectCategoryBoList.stream().map(category ->
                CompletableFuture.supplyAsync(() -> getLabelBoList(category),threadPoolExecutor)
        ).collect(Collectors.toList());
        completableFutureList.forEach(future -> {
            try {
                Map<Long,List<SubjectLabelBo>> resultMap = future.get();
                map.putAll(resultMap);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        subjectCategoryBoList.forEach(categoryBo -> {
            if (!CollectionUtils.isEmpty(map.get(categoryBo.getId()))) {
                categoryBo.setLabelBOList(map.get(categoryBo.getId()));
            }
        });
        return subjectCategoryBoList;
    }


    private Map<Long,List<SubjectLabelBo>> getLabelBoList(SubjectCategoryBo category) {
        if (log.isInfoEnabled()){
            log.info("SubjectCategoryBo queryCategoryAndLabel:{}", JSON.toJSONString(category));
        }
        Map<Long,List<SubjectLabelBo>> map = new HashMap<>();
        SubjectMappingEntity subjectMappingEntity = new SubjectMappingEntity();
        subjectMappingEntity.setCategoryId(category.getId());
        subjectMappingEntity.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectMappingEntity> subjectMappingEntityList = subjectMappingService.queryLabelId(subjectMappingEntity);
        if (CollectionUtils.isEmpty(subjectMappingEntityList)){
            return map;
        }
        List<Long> labelIdList = subjectMappingEntityList.stream().map(SubjectMappingEntity::getLabelId).collect(Collectors.toList());
        List<SubjectLabelEntity> subjectLabelEntityList = subjectLabelService.queryByLabelList(labelIdList);
        List<SubjectLabelBo> labelBos = new LinkedList<>();
        subjectLabelEntityList.forEach(labelEntity -> {
            SubjectLabelBo subjectLabelBo = new SubjectLabelBo();
            subjectLabelBo.setId(labelEntity.getId());
            subjectLabelBo.setLabelName(labelEntity.getLabelName());
            subjectLabelBo.setCategoryId(labelEntity.getCategoryId());
            subjectLabelBo.setSortNum(labelEntity.getSortNum());
            labelBos.add(subjectLabelBo);
        });
        map.put(category.getId(), labelBos);
        return map;

    }

}
