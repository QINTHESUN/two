package com.cp.subject.infra.basic.mapper;

import java.util.Date;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.subject.infra.basic.entity.SubjectCategoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题目分类(SubjectCategory)表数据库访问层
 * 
 * @author makejava
 * @since 2024-10-22 02:49:44
 */
@Mapper
public interface SubjectCategoryDao extends BaseMapper<SubjectCategoryEntity> {

}
