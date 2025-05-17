package com.cp.subject.infra.basic.service.impl;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.subject.common.enums.IsDeletedFlagEnum;
import com.cp.subject.infra.basic.mapper.SubjectMappingDao;
import com.cp.subject.infra.basic.entity.SubjectMappingEntity;
import com.cp.subject.infra.basic.service.SubjectMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 题目分类关系表(SubjectMapping)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-22 17:26:41
 */
@Service("subjectMappingService")
public class SubjectMappingServiceImpl extends ServiceImpl<SubjectMappingDao, SubjectMappingEntity> implements SubjectMappingService {

    @Resource
    private SubjectMappingDao subjectMappingDao;




    @Override
    public List<SubjectMappingEntity> queryLabelId(SubjectMappingEntity subjectMappingEntity) {
        LambdaQueryWrapper<SubjectMappingEntity> subjectMappingEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();

        subjectMappingEntityLambdaQueryWrapper.eq(SubjectMappingEntity::getCategoryId,subjectMappingEntity.getCategoryId())
                .eq(SubjectMappingEntity::getIsDeleted, IsDeletedFlagEnum.UN_DELETED.getCode());
        return subjectMappingDao.selectList(subjectMappingEntityLambdaQueryWrapper);
    }

    @Override
    public List<SubjectMappingEntity> queryBySubjectId(SubjectMappingEntity subjectMappingEntity) {
        LambdaQueryWrapper<SubjectMappingEntity> subjectMappingEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();

        subjectMappingEntityLambdaQueryWrapper.eq(SubjectMappingEntity::getSubjectId,subjectMappingEntity.getSubjectId());

        return subjectMappingDao.selectList(subjectMappingEntityLambdaQueryWrapper);
    }

    @Override
    public boolean delBySubjectId(Long id) {
        if (id == null) {
            return false;
        }

        LambdaUpdateWrapper<SubjectMappingEntity> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(SubjectMappingEntity::getSubjectId, id)
                .set(SubjectMappingEntity::getIsDeleted, IsDeletedFlagEnum.DELETED.getCode())
                .set(SubjectMappingEntity::getUpdateTime, new Date());


        return this.update(updateWrapper);
    }



}
