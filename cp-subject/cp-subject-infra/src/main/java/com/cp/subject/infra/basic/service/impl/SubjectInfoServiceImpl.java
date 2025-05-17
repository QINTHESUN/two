package com.cp.subject.infra.basic.service.impl;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.subject.common.enums.IsDeletedFlagEnum;
import com.cp.subject.infra.basic.entity.SubjectMappingEntity;
import com.cp.subject.infra.basic.mapper.SubjectInfoDao;
import com.cp.subject.infra.basic.entity.SubjectInfoEntity;
import com.cp.subject.infra.basic.service.SubjectInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 题目信息表(SubjectInfo)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-22 20:09:53
 */
@Service("subjectInfoService")
public class SubjectInfoServiceImpl extends ServiceImpl<SubjectInfoDao, SubjectInfoEntity> implements SubjectInfoService {

    @Resource
    private SubjectInfoDao subjectInfoDao;

    @Override
    public int queryCount(SubjectInfoEntity subjectInfoEntity, Long categoryId, Long labelId) {
        return  subjectInfoDao.queryCount(subjectInfoEntity,categoryId,labelId);
    }

    @Override
    public List<SubjectInfoEntity> queryPage(SubjectInfoEntity subjectInfoEntity, Long categoryId, Long labelId, int start, Integer pageSize) {
        return subjectInfoDao.queryPage(subjectInfoEntity,categoryId,labelId,start,pageSize);
    }

    @Override
    public SubjectInfoEntity queryById(SubjectInfoEntity subjectInfoEntity) {
        return subjectInfoDao.selectById(subjectInfoEntity.getId());
    }

    @Override
    public SubjectInfoEntity queryName(Long subjectId) {
        SubjectInfoEntity subjectInfoEntity = subjectInfoDao.selectById(subjectId);
        return subjectInfoEntity;
    }

    @Override
    public Boolean del(SubjectInfoEntity subjectInfoEntity) {
        // 使用 LambdaUpdateWrapper 构造更新条件
        LambdaUpdateWrapper<SubjectInfoEntity> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(SubjectInfoEntity::getId, subjectInfoEntity.getId())
                .set(SubjectInfoEntity::getIsDeleted, IsDeletedFlagEnum.DELETED.getCode())
                .set(SubjectInfoEntity::getUpdateTime, new Date());

        // 执行更新操作
        return this.update(lambdaUpdateWrapper);
    }

}
