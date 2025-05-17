package com.cp.subject.application.convert;

import com.cp.subject.application.dto.CommentsDto;
import com.cp.subject.application.dto.SubjectCategoryDto;
import com.cp.subject.domain.bo.CommentsBo;
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
public interface CommentsDtoConvert {

    CommentsDtoConvert INSTANCE = Mappers.getMapper(CommentsDtoConvert.class);

    CommentsBo convertDtoToBo(CommentsDto commentsDto);

    List<CommentsDto> convertBoToDtoList(List<CommentsBo> commentsBoList);

}
