package com.cp.subject.infra.basic.service.impl;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.subject.common.enums.IsDeletedFlagEnum;
import com.cp.subject.infra.basic.mapper.SubjectLabelDao;
import com.cp.subject.infra.basic.entity.SubjectLabelEntity;
import com.cp.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 题目标签表(SubjectLabel)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-22 14:19:42
 */
@Service("subjectLabelService")
public class SubjectLabelServiceImpl extends ServiceImpl<SubjectLabelDao, SubjectLabelEntity> implements SubjectLabelService {

    @Resource
    private SubjectLabelDao subjectLabelDao;


    @Override
    public Boolean add(SubjectLabelEntity subjectLabelEntity) {
        subjectLabelEntity.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        int count = subjectLabelDao.insert(subjectLabelEntity);
        return count > 0;
    }

    @Override
    public Boolean update(SubjectLabelEntity subjectLabelEntity) {
        int count = subjectLabelDao.updateById(subjectLabelEntity);
        return count>0;
    }

    @Override
    public Boolean delete(SubjectLabelEntity subjectLabelEntity) {
        subjectLabelEntity.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int count = subjectLabelDao.updateById(subjectLabelEntity);
        return count > 0;
    }

    @Override
    public List<SubjectLabelEntity> queryCondition(SubjectLabelEntity subjectLabelEntity) {
        LambdaQueryWrapper<SubjectLabelEntity> subjectLabelEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();

        subjectLabelEntityLambdaQueryWrapper.eq(SubjectLabelEntity::getCategoryId,subjectLabelEntity.getCategoryId())
                .eq(SubjectLabelEntity::getIsDeleted,IsDeletedFlagEnum.UN_DELETED.getCode());
        return subjectLabelDao.selectList(subjectLabelEntityLambdaQueryWrapper);
    }

    @Override
    public List<SubjectLabelEntity> selectBath(List<Long> labelList) {
        LambdaQueryWrapper<SubjectLabelEntity> subjectLabelEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();

        subjectLabelEntityLambdaQueryWrapper.in(SubjectLabelEntity::getId, labelList);
        return subjectLabelDao.selectList(subjectLabelEntityLambdaQueryWrapper);
    }

    @Override
    public List<SubjectLabelEntity> queryByLabelList(List<Long> labelList) {
        LambdaQueryWrapper<SubjectLabelEntity> subjectLabelEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();

        subjectLabelEntityLambdaQueryWrapper.in(SubjectLabelEntity::getId,labelList);
        return subjectLabelDao.selectList(subjectLabelEntityLambdaQueryWrapper);
    }
}
