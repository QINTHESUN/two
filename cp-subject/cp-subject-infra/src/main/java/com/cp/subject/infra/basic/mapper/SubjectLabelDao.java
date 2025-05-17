package com.cp.subject.infra.basic.mapper;

import java.util.Date;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.subject.infra.basic.entity.SubjectLabelEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题目标签表(SubjectLabel)表数据库访问层
 * 
 * @author makejava
 * @since 2024-10-22 14:19:42
 */
@Mapper
public interface SubjectLabelDao extends BaseMapper<SubjectLabelEntity> {

}
