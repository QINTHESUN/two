package com.cp.subject.domain.convert;

import com.cp.subject.domain.bo.SubjectAnswerBo;
import com.cp.subject.domain.bo.SubjectInfoBo;
import com.cp.subject.infra.basic.entity.SubjectBriefEntity;
import com.cp.subject.infra.basic.entity.SubjectRadioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/22 下午2:23
 **/
@Mapper
public interface SubjectRadioBoConvert {

    SubjectRadioBoConvert INSTANCE = Mappers.getMapper(SubjectRadioBoConvert.class);

    SubjectRadioEntity convertBoToEntity(SubjectAnswerBo subjectAnswerBo);

    List<SubjectAnswerBo> convertEntityToBoList(List<SubjectRadioEntity> subjectRadioEntities);

}
