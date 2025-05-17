package com.cp.subject.infra.basic.service.impl;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.subject.infra.basic.mapper.SubjectRadioDao;
import com.cp.subject.infra.basic.entity.SubjectRadioEntity;
import com.cp.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 单选题信息表(SubjectRadio)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-22 20:13:16
 */
@Service("subjectRadioService")
public class SubjectRadioServiceImpl extends ServiceImpl<SubjectRadioDao, SubjectRadioEntity> implements SubjectRadioService {

    @Resource
    private SubjectRadioDao subjectRadioDao;


    @Override
    public List<SubjectRadioEntity> queryBySubjectId(int subjectId) {
        LambdaQueryWrapper<SubjectRadioEntity> subjectRadioEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();

        subjectRadioEntityLambdaQueryWrapper.eq(SubjectRadioEntity::getSubjectId, subjectId);
        return subjectRadioDao.selectList(subjectRadioEntityLambdaQueryWrapper);
    }
}
