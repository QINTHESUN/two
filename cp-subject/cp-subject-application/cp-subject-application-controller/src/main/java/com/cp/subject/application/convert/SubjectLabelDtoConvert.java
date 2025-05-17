package com.cp.subject.application.convert;

import com.cp.subject.application.dto.SubjectLabelDto;
import com.cp.subject.domain.bo.SubjectLabelBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/22 下午2:22
 **/
@Mapper
public interface SubjectLabelDtoConvert {

    SubjectLabelDtoConvert INSTANCE = Mappers.getMapper(SubjectLabelDtoConvert.class);

    SubjectLabelBo convertDtoToBo(SubjectLabelDto dto);

    List<SubjectLabelDto> convertBoListToDtoList(List<SubjectLabelBo> boList);


}
