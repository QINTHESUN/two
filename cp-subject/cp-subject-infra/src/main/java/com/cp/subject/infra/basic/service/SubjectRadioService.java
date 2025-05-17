package com.cp.subject.infra.basic.service;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.subject.infra.basic.entity.SubjectRadioEntity;

/**
 * 单选题信息表(SubjectRadio)表服务接口
 * 
 * @author makejava
 * @since 2024-10-22 20:13:16
 */
public interface SubjectRadioService extends IService<SubjectRadioEntity> {

    /**
     * 根据subjectId查询单选题
     * @param subjectId
     * @return
     */
    List<SubjectRadioEntity> queryBySubjectId(int subjectId);
}
