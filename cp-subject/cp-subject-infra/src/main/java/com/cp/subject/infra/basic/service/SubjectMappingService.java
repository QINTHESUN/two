package com.cp.subject.infra.basic.service;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.subject.infra.basic.entity.SubjectMappingEntity;

/**
 * 题目分类关系表(SubjectMapping)表服务接口
 * 
 * @author makejava
 * @since 2024-10-22 17:26:41
 */
public interface SubjectMappingService extends IService<SubjectMappingEntity> {

    /**
     * 根据分类id获取所有的mapping
     * @param subjectMappingEntity
     * @return
     */
    List<SubjectMappingEntity> queryLabelId(SubjectMappingEntity subjectMappingEntity);


    /**
     * 根据subjectID查询mapping
     * @param subjectMappingEntity
     * @return
     */
    List<SubjectMappingEntity> queryBySubjectId(SubjectMappingEntity subjectMappingEntity);


    boolean delBySubjectId(Long id);
}
