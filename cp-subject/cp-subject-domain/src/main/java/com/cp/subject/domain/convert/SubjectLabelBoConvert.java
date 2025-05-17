package com.cp.subject.domain.convert;

import com.cp.subject.domain.bo.SubjectLabelBo;
import com.cp.subject.infra.basic.entity.SubjectLabelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/22 下午2:23
 **/
@Mapper
public interface SubjectLabelBoConvert {

    SubjectLabelBoConvert INSTANCE = Mappers.getMapper(SubjectLabelBoConvert.class);

    SubjectLabelEntity convertBoToEntity(SubjectLabelBo subjectLabelBo);

    List<SubjectLabelBo> convertEntityListToBoList(List<SubjectLabelEntity> subjectLabelEntities);

}
