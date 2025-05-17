package com.cp.subject.domain.convert;

import com.cp.subject.domain.bo.SubjectCategoryBo;
import com.cp.subject.infra.basic.entity.SubjectCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/22 上午2:56
 **/
@Mapper
public interface SubjectCategoryBoConvert {

    SubjectCategoryBoConvert INSTANCE = Mappers.getMapper(SubjectCategoryBoConvert.class);


    SubjectCategoryEntity convertBoToEntity(SubjectCategoryBo bo);


    List<SubjectCategoryBo> convertEntitiesToBos(List<SubjectCategoryEntity> entities);

}
