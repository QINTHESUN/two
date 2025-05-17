package com.cp.subject.application.convert;

import com.cp.subject.application.dto.SubjectAnswerDto;
import com.cp.subject.application.dto.SubjectInfoDto;
import com.cp.subject.application.dto.SubjectLikedDto;
import com.cp.subject.domain.bo.SubjectAnswerBo;
import com.cp.subject.domain.bo.SubjectInfoBo;
import com.cp.subject.domain.bo.SubjectLikedBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/22 下午2:22
 **/
@Mapper
public interface SubjectLikedDtoConvert {

    SubjectLikedDtoConvert INSTANCE = Mappers.getMapper(SubjectLikedDtoConvert.class);

    SubjectLikedBo convertDtoToBo(SubjectLikedDto dto);

}
