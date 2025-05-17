package com.cp.subject.application.convert;

import com.cp.subject.application.dto.SubjectCategoryDto;
import com.cp.subject.domain.bo.SubjectCategoryBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/22 上午2:56
 **/
@Mapper
public interface SubjectCategoryDtoConvert {

    SubjectCategoryDtoConvert INSTANCE = Mappers.getMapper(SubjectCategoryDtoConvert.class);

    SubjectCategoryBo convertDtoToBo(SubjectCategoryDto dto);

    SubjectCategoryDto convertBoToDto(SubjectCategoryBo bo);

    List<SubjectCategoryDto> convertBoToDtoList(List<SubjectCategoryBo> boList);


}
