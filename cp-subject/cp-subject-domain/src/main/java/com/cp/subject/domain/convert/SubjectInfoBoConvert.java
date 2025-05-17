package com.cp.subject.domain.convert;

import com.cp.subject.domain.bo.SubjectInfoBo;
import com.cp.subject.domain.bo.SubjectOptionBo;
import com.cp.subject.infra.basic.entity.SubjectBriefEntity;
import com.cp.subject.infra.basic.entity.SubjectInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/22 下午2:23
 **/
@Mapper
public interface SubjectInfoBoConvert {

    SubjectInfoBoConvert INSTANCE = Mappers.getMapper(SubjectInfoBoConvert.class);

    SubjectInfoEntity convertBoToEntity(SubjectInfoBo subjectInfoBo);

    List<SubjectInfoBo> convertEntityToBoList(List<SubjectInfoEntity> subjectInfoEntities);


    SubjectInfoBo convertBo(SubjectOptionBo subjectOptionBo,SubjectInfoEntity subjectInfoEntity);
}
