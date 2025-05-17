package com.cp.subject.infra.basic.mapper;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.subject.infra.basic.entity.SubjectInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 题目信息表(SubjectInfo)表数据库访问层
 * 
 * @author makejava
 * @since 2024-10-22 20:09:53
 */
@Mapper
public interface SubjectInfoDao extends BaseMapper<SubjectInfoEntity> {

    int queryCount(@Param("subjectInfoEntity") SubjectInfoEntity subjectInfoEntity,
                   @Param("categoryId") Long categoryId,
                   @Param("labelId") Long labelId);

    List<SubjectInfoEntity> queryPage(@Param("subjectInfoEntity") SubjectInfoEntity subjectInfoEntity,
                                      @Param("categoryId") Long categoryId,
                                      @Param("labelId") Long labelId,
                                      @Param("start") int start,
                                      @Param("pageSize") Integer pageSize);
}
