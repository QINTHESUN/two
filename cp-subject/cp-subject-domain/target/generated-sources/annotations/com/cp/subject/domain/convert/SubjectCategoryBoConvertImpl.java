package com.cp.subject.domain.convert;

import com.cp.subject.domain.bo.SubjectCategoryBo;
import com.cp.subject.infra.basic.entity.SubjectCategoryEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:17:09+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class SubjectCategoryBoConvertImpl implements SubjectCategoryBoConvert {

    @Override
    public SubjectCategoryEntity convertBoToEntity(SubjectCategoryBo bo) {
        if ( bo == null ) {
            return null;
        }

        SubjectCategoryEntity subjectCategoryEntity = new SubjectCategoryEntity();

        subjectCategoryEntity.setId( bo.getId() );
        subjectCategoryEntity.setCategoryName( bo.getCategoryName() );
        subjectCategoryEntity.setCategoryType( bo.getCategoryType() );
        subjectCategoryEntity.setImageUrl( bo.getImageUrl() );
        subjectCategoryEntity.setParentId( bo.getParentId() );
        subjectCategoryEntity.setCreatedBy( bo.getCreatedBy() );
        subjectCategoryEntity.setCreatedTime( bo.getCreatedTime() );
        subjectCategoryEntity.setUpdateBy( bo.getUpdateBy() );
        subjectCategoryEntity.setUpdateTime( bo.getUpdateTime() );
        subjectCategoryEntity.setIsDeleted( bo.getIsDeleted() );

        return subjectCategoryEntity;
    }

    @Override
    public List<SubjectCategoryBo> convertEntitiesToBos(List<SubjectCategoryEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<SubjectCategoryBo> list = new ArrayList<SubjectCategoryBo>( entities.size() );
        for ( SubjectCategoryEntity subjectCategoryEntity : entities ) {
            list.add( subjectCategoryEntityToSubjectCategoryBo( subjectCategoryEntity ) );
        }

        return list;
    }

    protected SubjectCategoryBo subjectCategoryEntityToSubjectCategoryBo(SubjectCategoryEntity subjectCategoryEntity) {
        if ( subjectCategoryEntity == null ) {
            return null;
        }

        SubjectCategoryBo subjectCategoryBo = new SubjectCategoryBo();

        subjectCategoryBo.setId( subjectCategoryEntity.getId() );
        subjectCategoryBo.setCategoryName( subjectCategoryEntity.getCategoryName() );
        subjectCategoryBo.setCategoryType( subjectCategoryEntity.getCategoryType() );
        subjectCategoryBo.setImageUrl( subjectCategoryEntity.getImageUrl() );
        subjectCategoryBo.setParentId( subjectCategoryEntity.getParentId() );
        subjectCategoryBo.setCreatedBy( subjectCategoryEntity.getCreatedBy() );
        subjectCategoryBo.setCreatedTime( subjectCategoryEntity.getCreatedTime() );
        subjectCategoryBo.setUpdateBy( subjectCategoryEntity.getUpdateBy() );
        subjectCategoryBo.setUpdateTime( subjectCategoryEntity.getUpdateTime() );
        subjectCategoryBo.setIsDeleted( subjectCategoryEntity.getIsDeleted() );

        return subjectCategoryBo;
    }
}
