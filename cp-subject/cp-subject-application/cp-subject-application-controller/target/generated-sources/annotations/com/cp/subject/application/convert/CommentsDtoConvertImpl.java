package com.cp.subject.application.convert;

import com.cp.subject.application.dto.CommentsDto;
import com.cp.subject.domain.bo.CommentsBo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:17:12+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class CommentsDtoConvertImpl implements CommentsDtoConvert {

    @Override
    public CommentsBo convertDtoToBo(CommentsDto commentsDto) {
        if ( commentsDto == null ) {
            return null;
        }

        CommentsBo commentsBo = new CommentsBo();

        commentsBo.setId( commentsDto.getId() );
        commentsBo.setTopicId( commentsDto.getTopicId() );
        commentsBo.setParentId( commentsDto.getParentId() );
        commentsBo.setUserId( commentsDto.getUserId() );
        commentsBo.setContent( commentsDto.getContent() );
        commentsBo.setCreatedAt( commentsDto.getCreatedAt() );
        commentsBo.setIsDeleted( commentsDto.getIsDeleted() );

        return commentsBo;
    }

    @Override
    public List<CommentsDto> convertBoToDtoList(List<CommentsBo> commentsBoList) {
        if ( commentsBoList == null ) {
            return null;
        }

        List<CommentsDto> list = new ArrayList<CommentsDto>( commentsBoList.size() );
        for ( CommentsBo commentsBo : commentsBoList ) {
            list.add( commentsBoToCommentsDto( commentsBo ) );
        }

        return list;
    }

    protected CommentsDto commentsBoToCommentsDto(CommentsBo commentsBo) {
        if ( commentsBo == null ) {
            return null;
        }

        CommentsDto commentsDto = new CommentsDto();

        commentsDto.setId( commentsBo.getId() );
        commentsDto.setTopicId( commentsBo.getTopicId() );
        commentsDto.setParentId( commentsBo.getParentId() );
        commentsDto.setUserId( commentsBo.getUserId() );
        commentsDto.setContent( commentsBo.getContent() );
        commentsDto.setCreatedAt( commentsBo.getCreatedAt() );
        commentsDto.setIsDeleted( commentsBo.getIsDeleted() );

        return commentsDto;
    }
}
