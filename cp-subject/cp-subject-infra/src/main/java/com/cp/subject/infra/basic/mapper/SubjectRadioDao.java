package com.cp.subject.infra.basic.mapper;

import java.util.Date;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.subject.infra.basic.entity.SubjectRadioEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 单选题信息表(SubjectRadio)表数据库访问层
 * 
 * @author makejava
 * @since 2024-10-22 20:13:16
 */
@Mapper
public interface SubjectRadioDao extends BaseMapper<SubjectRadioEntity> {

}
