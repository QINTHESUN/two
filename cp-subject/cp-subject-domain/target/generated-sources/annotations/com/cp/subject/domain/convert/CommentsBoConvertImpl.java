package com.cp.subject.domain.convert;

import com.cp.subject.domain.bo.CommentsBo;
import com.cp.subject.infra.basic.entity.CommentsEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:17:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class CommentsBoConvertImpl implements CommentsBoConvert {

    @Override
    public CommentsEntity convertBoToEntity(CommentsBo commentsBo) {
        if ( commentsBo == null ) {
            return null;
        }

        CommentsEntity commentsEntity = new CommentsEntity();

        commentsEntity.setId( commentsBo.getId() );
        commentsEntity.setTopicId( commentsBo.getTopicId() );
        commentsEntity.setParentId( commentsBo.getParentId() );
        commentsEntity.setUserId( commentsBo.getUserId() );
        commentsEntity.setContent( commentsBo.getContent() );
        commentsEntity.setCreatedAt( commentsBo.getCreatedAt() );
        commentsEntity.setIsDeleted( commentsBo.getIsDeleted() );

        return commentsEntity;
    }

    @Override
    public List<CommentsBo> convertEntityToBoList(List<CommentsEntity> commentsEntities) {
        if ( commentsEntities == null ) {
            return null;
        }

        List<CommentsBo> list = new ArrayList<CommentsBo>( commentsEntities.size() );
        for ( CommentsEntity commentsEntity : commentsEntities ) {
            list.add( commentsEntityToCommentsBo( commentsEntity ) );
        }

        return list;
    }

    protected CommentsBo commentsEntityToCommentsBo(CommentsEntity commentsEntity) {
        if ( commentsEntity == null ) {
            return null;
        }

        CommentsBo commentsBo = new CommentsBo();

        commentsBo.setId( commentsEntity.getId() );
        commentsBo.setTopicId( commentsEntity.getTopicId() );
        commentsBo.setParentId( commentsEntity.getParentId() );
        commentsBo.setUserId( commentsEntity.getUserId() );
        commentsBo.setContent( commentsEntity.getContent() );
        commentsBo.setCreatedAt( commentsEntity.getCreatedAt() );
        commentsBo.setIsDeleted( commentsEntity.getIsDeleted() );

        return commentsBo;
    }
}
