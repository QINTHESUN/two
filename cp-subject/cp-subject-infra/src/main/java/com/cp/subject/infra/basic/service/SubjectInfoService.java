package com.cp.subject.infra.basic.service;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.subject.infra.basic.entity.SubjectInfoEntity;
import com.cp.subject.infra.basic.entity.SubjectMappingEntity;

/**
 * 题目信息表(SubjectInfo)表服务接口
 * 
 * @author makejava
 * @since 2024-10-22 20:09:52
 */
public interface SubjectInfoService extends IService<SubjectInfoEntity> {

    /**
     * 查询题目数量
     * @param subjectInfoEntity
     * @param categoryId
     * @param labelId
     * @return
     */
    int queryCount(SubjectInfoEntity subjectInfoEntity, Long categoryId, Long labelId);

    /**
     * 分页查询题目列表
     * @param subjectInfoEntity
     * @param categoryId
     * @param labelId
     * @param start
     * @param pageSize
     * @return
     */
    List<SubjectInfoEntity> queryPage(SubjectInfoEntity subjectInfoEntity, Long categoryId, Long labelId, int start, Integer pageSize);


    /**
     * 根据id查询题目信息
     * @param subjectInfoEntity
     * @return
     */
    SubjectInfoEntity queryById(SubjectInfoEntity subjectInfoEntity);


    /**
     * 根据subjectId查询题目
     * @param subjectId
     * @return
     */
    SubjectInfoEntity queryName(Long subjectId);

    /**
     * 删除题目
     * @param subjectInfoEntity
     */
    Boolean del(SubjectInfoEntity subjectInfoEntity);
}
