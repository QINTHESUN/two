package com.cp.subject.infra.basic.service.impl;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.subject.infra.basic.mapper.SubjectJudgeDao;
import com.cp.subject.infra.basic.entity.SubjectJudgeEntity;
import com.cp.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 判断题(SubjectJudge)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-22 20:12:39
 */
@Service("subjectJudgeService")
public class SubjectJudgeServiceImpl extends ServiceImpl<SubjectJudgeDao, SubjectJudgeEntity> implements SubjectJudgeService {

    @Resource
    private SubjectJudgeDao subjectJudgeDao;


    @Override
    public List<SubjectJudgeEntity> queryBySubjectId(int subjectId) {
        LambdaQueryWrapper<SubjectJudgeEntity> subjectJudgeEntityLambdaQueryWrapper =
                new LambdaQueryWrapper<>();
        subjectJudgeEntityLambdaQueryWrapper.eq(SubjectJudgeEntity::getSubjectId,subjectId);
        return subjectJudgeDao.selectList(subjectJudgeEntityLambdaQueryWrapper);

    }
}
