package com.cp.subject.domain.convert;

import com.cp.subject.domain.bo.SubjectLikedBo;
import com.cp.subject.infra.basic.entity.SubjectLikedEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:17:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class SubjectLikedBoConvertImpl implements SubjectLikedBoConvert {

    @Override
    public SubjectLikedEntity convertBoToEntity(SubjectLikedBo subjectLikedBo) {
        if ( subjectLikedBo == null ) {
            return null;
        }

        SubjectLikedEntity subjectLikedEntity = new SubjectLikedEntity();

        subjectLikedEntity.setId( subjectLikedBo.getId() );
        subjectLikedEntity.setSubjectId( subjectLikedBo.getSubjectId() );
        subjectLikedEntity.setLikeUserId( subjectLikedBo.getLikeUserId() );
        subjectLikedEntity.setStatus( subjectLikedBo.getStatus() );
        subjectLikedEntity.setCreatedBy( subjectLikedBo.getCreatedBy() );
        subjectLikedEntity.setCreatedTime( subjectLikedBo.getCreatedTime() );
        subjectLikedEntity.setUpdateBy( subjectLikedBo.getUpdateBy() );
        subjectLikedEntity.setUpdateTime( subjectLikedBo.getUpdateTime() );
        subjectLikedEntity.setIsDeleted( subjectLikedBo.getIsDeleted() );

        return subjectLikedEntity;
    }

    @Override
    public List<SubjectLikedBo> convertEntitiesToBos(List<SubjectLikedEntity> subjectLikedEntities) {
        if ( subjectLikedEntities == null ) {
            return null;
        }

        List<SubjectLikedBo> list = new ArrayList<SubjectLikedBo>( subjectLikedEntities.size() );
        for ( SubjectLikedEntity subjectLikedEntity : subjectLikedEntities ) {
            list.add( subjectLikedEntityToSubjectLikedBo( subjectLikedEntity ) );
        }

        return list;
    }

    protected SubjectLikedBo subjectLikedEntityToSubjectLikedBo(SubjectLikedEntity subjectLikedEntity) {
        if ( subjectLikedEntity == null ) {
            return null;
        }

        SubjectLikedBo subjectLikedBo = new SubjectLikedBo();

        subjectLikedBo.setId( subjectLikedEntity.getId() );
        subjectLikedBo.setSubjectId( subjectLikedEntity.getSubjectId() );
        subjectLikedBo.setLikeUserId( subjectLikedEntity.getLikeUserId() );
        subjectLikedBo.setStatus( subjectLikedEntity.getStatus() );
        subjectLikedBo.setCreatedBy( subjectLikedEntity.getCreatedBy() );
        subjectLikedBo.setCreatedTime( subjectLikedEntity.getCreatedTime() );
        subjectLikedBo.setUpdateBy( subjectLikedEntity.getUpdateBy() );
        subjectLikedBo.setUpdateTime( subjectLikedEntity.getUpdateTime() );
        subjectLikedBo.setIsDeleted( subjectLikedEntity.getIsDeleted() );

        return subjectLikedBo;
    }
}
