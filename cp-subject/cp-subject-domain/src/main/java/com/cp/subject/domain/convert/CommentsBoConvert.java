package com.cp.subject.domain.convert;

import com.cp.subject.domain.bo.CommentsBo;
import com.cp.subject.infra.basic.entity.CommentsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/22 上午2:56
 **/
@Mapper
public interface CommentsBoConvert {

    CommentsBoConvert INSTANCE = Mappers.getMapper(CommentsBoConvert.class);

    CommentsEntity convertBoToEntity(CommentsBo commentsBo);

    List<CommentsBo> convertEntityToBoList(List<CommentsEntity> commentsEntities);

}
