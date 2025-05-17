package com.cp.subject.infra.basic.service.impl;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.subject.infra.basic.mapper.SubjectLikedDao;
import com.cp.subject.infra.basic.entity.SubjectLikedEntity;
import com.cp.subject.infra.basic.service.SubjectLikedService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 题目点赞表(SubjectLiked)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-31 10:34:01
 */
@Service("subjectLikedService")
public class SubjectLikedServiceImpl extends ServiceImpl<SubjectLikedDao, SubjectLikedEntity> implements SubjectLikedService {

    @Resource
    private SubjectLikedDao subjectLikedDao;


    @Override
    public void batchInsert(List<SubjectLikedEntity> subjectLikedEntityList) {

    }

    @Override
    public int countByCondition(SubjectLikedEntity subjectLikedEntity) {
        LambdaQueryWrapper<SubjectLikedEntity> subjectLikedEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        subjectLikedEntityLambdaQueryWrapper.eq(SubjectLikedEntity::getLikeUserId,subjectLikedEntity.getLikeUserId());
        Integer count = subjectLikedDao.selectCount(subjectLikedEntityLambdaQueryWrapper);
        return count;
    }

    @Override
    public List<SubjectLikedEntity> queryPage(SubjectLikedEntity subjectLikedEntity, int start, Integer pageSize) {
        return subjectLikedDao.queryPage(subjectLikedEntity,start,pageSize);
    }
}
