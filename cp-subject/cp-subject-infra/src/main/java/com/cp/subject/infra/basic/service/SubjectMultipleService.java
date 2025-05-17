package com.cp.subject.infra.basic.service;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.subject.infra.basic.entity.SubjectMultipleEntity;

/**
 * 多选题信息表(SubjectMultiple)表服务接口
 * 
 * @author makejava
 * @since 2024-10-22 20:13:03
 */
public interface SubjectMultipleService extends IService<SubjectMultipleEntity> {

    /**
     * 根据subjectId查询多选题
     * @param subjectId
     * @return
     */
    List<SubjectMultipleEntity> queryBySubjectId(int subjectId);
}
