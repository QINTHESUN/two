package com.cp.subject.application.convert;

import com.cp.subject.application.dto.SubjectAnswerDto;
import com.cp.subject.application.dto.SubjectInfoDto;
import com.cp.subject.application.dto.SubjectLabelDto;
import com.cp.subject.domain.bo.SubjectAnswerBo;
import com.cp.subject.domain.bo.SubjectInfoBo;
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
public interface SubjectInfoDtoConvert {

    SubjectInfoDtoConvert INSTANCE = Mappers.getMapper(SubjectInfoDtoConvert.class);

    SubjectInfoBo convertDtoToBo(SubjectInfoDto dto);

    SubjectInfoDto convertBoToDto(SubjectInfoBo bo);

    List<SubjectAnswerBo> subjectAnswerDtoToBoList(List<SubjectAnswerDto> dtoList);

    List<SubjectInfoDto> convertBoListToDtoList(List<SubjectInfoBo> boList);

}
