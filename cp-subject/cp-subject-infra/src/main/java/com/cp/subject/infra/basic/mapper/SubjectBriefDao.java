package com.cp.subject.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.subject.infra.basic.entity.SubjectBriefEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 简答题(SubjectBrief)表数据库访问层
 * 
 * @author makejava
 * @since 2024-10-22 20:10:39
 */
@Mapper
public interface SubjectBriefDao extends BaseMapper<SubjectBriefEntity> {

}
