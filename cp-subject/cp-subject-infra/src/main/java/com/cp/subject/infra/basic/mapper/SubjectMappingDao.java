package com.cp.subject.infra.basic.mapper;

import java.util.Date;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.subject.infra.basic.entity.SubjectMappingEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题目分类关系表(SubjectMapping)表数据库访问层
 * 
 * @author makejava
 * @since 2024-10-22 17:26:41
 */
@Mapper
public interface SubjectMappingDao extends BaseMapper<SubjectMappingEntity> {

}
