package com.cp.subject.domain.convert;

import com.cp.subject.domain.bo.SubjectInfoBo;
import com.cp.subject.domain.bo.SubjectLikedBo;
import com.cp.subject.infra.basic.entity.SubjectBriefEntity;
import com.cp.subject.infra.basic.entity.SubjectLikedEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/22 下午2:23
 **/
@Mapper
public interface SubjectLikedBoConvert {

    SubjectLikedBoConvert INSTANCE = Mappers.getMapper(SubjectLikedBoConvert.class);

    SubjectLikedEntity convertBoToEntity(SubjectLikedBo subjectLikedBo);

    List<SubjectLikedBo> convertEntitiesToBos(List<SubjectLikedEntity> subjectLikedEntities);
}
