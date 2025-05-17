package com.cp.subject.infra.basic.mapper;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.subject.infra.basic.entity.SubjectLikedEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 题目点赞表(SubjectLiked)表数据库访问层
 * 
 * @author makejava
 * @since 2024-10-31 10:34:01
 */
@Mapper
public interface SubjectLikedDao extends BaseMapper<SubjectLikedEntity> {

    /**
     * 分页查询
     * @param subjectLikedEntity
     * @param start
     * @param pageSize
     * @return
     */
    List<SubjectLikedEntity> queryPage(@Param("entity") SubjectLikedEntity subjectLikedEntity,
                                       @Param("start") int start,
                                       @Param("pageSize") Integer pageSize);
}
