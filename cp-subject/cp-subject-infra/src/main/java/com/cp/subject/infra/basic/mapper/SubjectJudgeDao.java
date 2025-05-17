package com.cp.subject.infra.basic.mapper;

import java.util.Date;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.subject.infra.basic.entity.SubjectJudgeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 判断题(SubjectJudge)表数据库访问层
 * 
 * @author makejava
 * @since 2024-10-22 20:12:40
 */
@Mapper
public interface SubjectJudgeDao extends BaseMapper<SubjectJudgeEntity> {

}
