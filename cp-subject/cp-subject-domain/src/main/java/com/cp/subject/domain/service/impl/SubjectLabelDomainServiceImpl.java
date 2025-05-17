package com.cp.subject.domain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.subject.common.enums.CategoryTypeEnum;
import com.cp.subject.common.enums.IsDeletedFlagEnum;
import com.cp.subject.domain.bo.SubjectLabelBo;
import com.cp.subject.domain.convert.SubjectLabelBoConvert;
import com.cp.subject.domain.service.SubjectLabelDomainService;
import com.cp.subject.infra.basic.entity.SubjectCategoryEntity;
import com.cp.subject.infra.basic.entity.SubjectLabelEntity;
import com.cp.subject.infra.basic.entity.SubjectMappingEntity;
import com.cp.subject.infra.basic.mapper.SubjectLabelDao;
import com.cp.subject.infra.basic.service.SubjectCategoryService;
import com.cp.subject.infra.basic.service.SubjectLabelService;
import com.cp.subject.infra.basic.service.SubjectMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.security.auth.Subject;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 题目标签表(SubjectLabel)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-22 14:19:42
 */
@Service
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Override
    public Boolean add(SubjectLabelBo subjectLabelBo) {
        SubjectLabelEntity subjectLabelEntity = SubjectLabelBoConvert.INSTANCE.convertBoToEntity(subjectLabelBo);
        return subjectLabelService.add(subjectLabelEntity);
    }

    @Override
    public Boolean update(SubjectLabelBo subjectLabelBo) {
        SubjectLabelEntity subjectLabelEntity = SubjectLabelBoConvert.INSTANCE.convertBoToEntity(subjectLabelBo);
        return subjectLabelService.update(subjectLabelEntity);
    }

    @Override
    public Boolean delete(SubjectLabelBo subjectLabelBo) {
        SubjectLabelEntity subjectLabelEntity = SubjectLabelBoConvert.INSTANCE.convertBoToEntity(subjectLabelBo);
        return subjectLabelService.delete(subjectLabelEntity);
    }

    @Override
    public List<SubjectLabelBo> queryByCategoryId(SubjectLabelBo subjectLabelBo) {
        SubjectCategoryEntity subjectCategoryEntity =
                subjectCategoryService.queryCategoryType(subjectLabelBo.getCategoryId());
        if (CategoryTypeEnum.PRIMARY.code == subjectCategoryEntity.getCategoryType()){
            SubjectLabelEntity subjectLabelEntity =
                    SubjectLabelBoConvert.INSTANCE.convertBoToEntity(subjectLabelBo);
            List<SubjectLabelEntity> subjectLabelEntityList =
                    subjectLabelService.queryCondition(subjectLabelEntity);
            List<SubjectLabelBo> subjectLabelBos =
                    SubjectLabelBoConvert.INSTANCE.convertEntityListToBoList(subjectLabelEntityList);
            return subjectLabelBos;
        }
        SubjectMappingEntity subjectMappingEntity = new SubjectMappingEntity();
        subjectMappingEntity.setCategoryId(Long.valueOf(subjectLabelBo.getCategoryId()));
        subjectMappingEntity.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectMappingEntity> subjectMappingEntityList =
                subjectMappingService.queryLabelId(subjectMappingEntity);
        List<Long> labelList =
                subjectMappingEntityList.stream().
                        map(SubjectMappingEntity::getLabelId).collect(Collectors.toList());
        List<SubjectLabelEntity> subjectLabelEntityList =
                subjectLabelService.selectBath(labelList);
        List<SubjectLabelBo> result =
                SubjectLabelBoConvert.INSTANCE.convertEntityListToBoList(subjectLabelEntityList);
        return result;
    }
}
