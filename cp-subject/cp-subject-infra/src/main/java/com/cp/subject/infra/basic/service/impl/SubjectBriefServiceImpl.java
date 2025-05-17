package com.cp.subject.infra.basic.service.impl;
import java.util.Date;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.subject.infra.basic.mapper.SubjectBriefDao;
import com.cp.subject.infra.basic.entity.SubjectBriefEntity;
import com.cp.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 简答题(SubjectBrief)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-22 20:10:39
 */
@Service("subjectBriefService")
public class SubjectBriefServiceImpl extends ServiceImpl<SubjectBriefDao, SubjectBriefEntity> implements SubjectBriefService {


    @Resource
    private SubjectBriefDao subjectBriefDao;


    @Override
    public SubjectBriefEntity queryBySubjectId(SubjectBriefEntity subjectBriefEntity) {
        LambdaQueryWrapper<SubjectBriefEntity> subjectBriefEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();

        subjectBriefEntityLambdaQueryWrapper.eq(SubjectBriefEntity::getSubjectId,subjectBriefEntity.getSubjectId());
        return subjectBriefDao.selectOne(subjectBriefEntityLambdaQueryWrapper);
    }
}
