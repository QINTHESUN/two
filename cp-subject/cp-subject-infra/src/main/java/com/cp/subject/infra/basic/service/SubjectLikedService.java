package com.cp.subject.infra.basic.service;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.subject.infra.basic.entity.SubjectLikedEntity;

/**
 * 题目点赞表(SubjectLiked)表服务接口
 * 
 * @author makejava
 * @since 2024-10-31 10:34:01
 */
public interface SubjectLikedService extends IService<SubjectLikedEntity> {

    /**
     * 批量插入
     * @param subjectLikedEntityList
     */
    void batchInsert(List<SubjectLikedEntity> subjectLikedEntityList);

    /**
     * 根据用户查询题目数量
     * @param subjectLikedEntity
     * @return
     */
    int countByCondition(SubjectLikedEntity subjectLikedEntity);

    /**
     * 分页查询
     * @param subjectLikedEntity
     * @param start
     * @param pageSize
     * @return
     */
    List<SubjectLikedEntity> queryPage(SubjectLikedEntity subjectLikedEntity, int start, Integer pageSize);
}
