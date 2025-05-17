package com.cp.subject.infra.basic.service.impl;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.subject.common.enums.IsDeletedFlagEnum;
import com.cp.subject.infra.basic.mapper.SubjectCategoryDao;
import com.cp.subject.infra.basic.entity.SubjectCategoryEntity;
import com.cp.subject.infra.basic.mapper.SubjectLabelDao;
import com.cp.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 题目分类(SubjectCategory)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-22 02:49:43
 */
@Service("subjectCategoryService")
@Slf4j
public class SubjectCategoryServiceImpl extends ServiceImpl<SubjectCategoryDao, SubjectCategoryEntity> implements SubjectCategoryService {
    @Resource
    private SubjectCategoryDao subjectCategoryDao;

    @Autowired
    private SubjectLabelDao subjectLabelDao;

    @Override
    public Boolean add(SubjectCategoryEntity subjectCategoryEntity) {
        int count = subjectCategoryDao.insert(subjectCategoryEntity);
        return count > 0;
    }

    @Override
    public Boolean update(SubjectCategoryEntity subjectCategoryEntity) {
        LambdaUpdateWrapper<SubjectCategoryEntity> subjectCategoryEntityLambdaUpdateWrapper = new LambdaUpdateWrapper<>();

        subjectCategoryEntityLambdaUpdateWrapper.eq(SubjectCategoryEntity::getId,subjectCategoryEntity.getId());
        int count = subjectCategoryDao.update(subjectCategoryEntity, subjectCategoryEntityLambdaUpdateWrapper);
        return count > 0;
    }

    @Override
    public List<SubjectCategoryEntity> queryByType(SubjectCategoryEntity subjectCategoryEntity) {
        LambdaQueryWrapper<SubjectCategoryEntity> subjectCategoryEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();

        subjectCategoryEntityLambdaQueryWrapper.eq(SubjectCategoryEntity::getCategoryType,subjectCategoryEntity.getCategoryType())
                .eq(SubjectCategoryEntity::getIsDeleted,IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectCategoryEntity> subjectCategoryEntityList = subjectCategoryDao.selectList(subjectCategoryEntityLambdaQueryWrapper);
        return subjectCategoryEntityList;
    }

    @Override
    public int queryCount(Long id) {
        LambdaQueryWrapper<SubjectCategoryEntity> subjectCategoryEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        subjectCategoryEntityLambdaQueryWrapper.eq(SubjectCategoryEntity::getId,id);
        return subjectCategoryDao.selectCount(subjectCategoryEntityLambdaQueryWrapper);

    }

    @Override
    public Boolean delete(SubjectCategoryEntity subjectCategoryEntity) {
        LambdaUpdateWrapper<SubjectCategoryEntity> subjectCategoryEntityLambdaUpdateWrapper = new LambdaUpdateWrapper<>();

        subjectCategoryEntityLambdaUpdateWrapper.eq(SubjectCategoryEntity::getId,subjectCategoryEntity.getId())
                .set(SubjectCategoryEntity::getIsDeleted,IsDeletedFlagEnum.DELETED.getCode());
        int count = subjectCategoryDao.update(subjectCategoryEntity, subjectCategoryEntityLambdaUpdateWrapper);
        return count > 0;
    }

    @Override
    public SubjectCategoryEntity queryCategoryType(String categoryId) {
        LambdaQueryWrapper<SubjectCategoryEntity> subjectCategoryEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();

        subjectCategoryEntityLambdaQueryWrapper.eq(SubjectCategoryEntity::getId,categoryId)
                .eq(SubjectCategoryEntity::getIsDeleted,IsDeletedFlagEnum.UN_DELETED.getCode());
        return subjectCategoryDao.selectOne(subjectCategoryEntityLambdaQueryWrapper);
    }

    @Override
    public List<SubjectCategoryEntity> queryCategory(Long categoryId) {
        LambdaQueryWrapper<SubjectCategoryEntity> subjectCategoryEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        subjectCategoryEntityLambdaQueryWrapper.eq(SubjectCategoryEntity::getId,categoryId)
                .eq(SubjectCategoryEntity::getIsDeleted,IsDeletedFlagEnum.UN_DELETED.getCode());
        return subjectCategoryDao.selectList(subjectCategoryEntityLambdaQueryWrapper);
    }

    @Override
    public List<SubjectCategoryEntity> queryAll(int code) {
        LambdaQueryWrapper<SubjectCategoryEntity> subjectCategoryEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        subjectCategoryEntityLambdaQueryWrapper.eq(SubjectCategoryEntity::getIsDeleted,code);
        return subjectCategoryDao.selectList(subjectCategoryEntityLambdaQueryWrapper);
    }
}
