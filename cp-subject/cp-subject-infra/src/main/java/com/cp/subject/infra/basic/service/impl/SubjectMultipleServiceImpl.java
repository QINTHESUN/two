package com.cp.subject.infra.basic.service.impl;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.subject.infra.basic.mapper.SubjectMultipleDao;
import com.cp.subject.infra.basic.entity.SubjectMultipleEntity;
import com.cp.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 多选题信息表(SubjectMultiple)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-22 20:13:03
 */
@Service("subjectMultipleService")
public class SubjectMultipleServiceImpl extends ServiceImpl<SubjectMultipleDao, SubjectMultipleEntity> implements SubjectMultipleService {

    @Resource
    private SubjectMultipleDao subjectMultipleDao;


    @Override
    public List<SubjectMultipleEntity> queryBySubjectId(int subjectId) {
        LambdaQueryWrapper<SubjectMultipleEntity> subjectMultipleEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();

        subjectMultipleEntityLambdaQueryWrapper.eq(SubjectMultipleEntity::getSubjectId, subjectId);
        return subjectMultipleDao.selectList(subjectMultipleEntityLambdaQueryWrapper);
    }
}
