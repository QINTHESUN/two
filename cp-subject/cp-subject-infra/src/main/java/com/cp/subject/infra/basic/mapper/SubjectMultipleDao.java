package com.cp.subject.infra.basic.mapper;

import java.util.Date;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.subject.infra.basic.entity.SubjectMultipleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 多选题信息表(SubjectMultiple)表数据库访问层
 * 
 * @author makejava
 * @since 2024-10-22 20:13:03
 */
@Mapper
public interface SubjectMultipleDao extends BaseMapper<SubjectMultipleEntity> {

}
