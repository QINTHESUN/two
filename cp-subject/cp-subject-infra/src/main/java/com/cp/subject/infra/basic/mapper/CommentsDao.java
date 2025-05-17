package com.cp.subject.infra.basic.mapper;

import java.util.Date;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.subject.infra.basic.entity.CommentsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Comments)表数据库访问层
 * 
 * @author makejava
 * @since 2024-11-08 15:16:11
 */
@Mapper
public interface CommentsDao extends BaseMapper<CommentsEntity> {

}
