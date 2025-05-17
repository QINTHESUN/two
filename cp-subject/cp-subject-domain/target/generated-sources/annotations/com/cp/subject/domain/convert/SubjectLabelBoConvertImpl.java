package com.cp.subject.domain.convert;

import com.cp.subject.domain.bo.SubjectLabelBo;
import com.cp.subject.infra.basic.entity.SubjectLabelEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:17:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class SubjectLabelBoConvertImpl implements SubjectLabelBoConvert {

    @Override
    public SubjectLabelEntity convertBoToEntity(SubjectLabelBo subjectLabelBo) {
        if ( subjectLabelBo == null ) {
            return null;
        }

        SubjectLabelEntity subjectLabelEntity = new SubjectLabelEntity();

        subjectLabelEntity.setId( subjectLabelBo.getId() );
        subjectLabelEntity.setLabelName( subjectLabelBo.getLabelName() );
        subjectLabelEntity.setSortNum( subjectLabelBo.getSortNum() );
        subjectLabelEntity.setCategoryId( subjectLabelBo.getCategoryId() );
        subjectLabelEntity.setCreatedBy( subjectLabelBo.getCreatedBy() );
        subjectLabelEntity.setCreatedTime( subjectLabelBo.getCreatedTime() );
        subjectLabelEntity.setUpdateBy( subjectLabelBo.getUpdateBy() );
        subjectLabelEntity.setUpdateTime( subjectLabelBo.getUpdateTime() );
        subjectLabelEntity.setIsDeleted( subjectLabelBo.getIsDeleted() );

        return subjectLabelEntity;
    }

    @Override
    public List<SubjectLabelBo> convertEntityListToBoList(List<SubjectLabelEntity> subjectLabelEntities) {
        if ( subjectLabelEntities == null ) {
            return null;
        }

        List<SubjectLabelBo> list = new ArrayList<SubjectLabelBo>( subjectLabelEntities.size() );
        for ( SubjectLabelEntity subjectLabelEntity : subjectLabelEntities ) {
            list.add( subjectLabelEntityToSubjectLabelBo( subjectLabelEntity ) );
        }

        return list;
    }

    protected SubjectLabelBo subjectLabelEntityToSubjectLabelBo(SubjectLabelEntity subjectLabelEntity) {
        if ( subjectLabelEntity == null ) {
            return null;
        }

        SubjectLabelBo subjectLabelBo = new SubjectLabelBo();

        subjectLabelBo.setId( subjectLabelEntity.getId() );
        subjectLabelBo.setLabelName( subjectLabelEntity.getLabelName() );
        subjectLabelBo.setSortNum( subjectLabelEntity.getSortNum() );
        subjectLabelBo.setCategoryId( subjectLabelEntity.getCategoryId() );
        subjectLabelBo.setCreatedBy( subjectLabelEntity.getCreatedBy() );
        subjectLabelBo.setCreatedTime( subjectLabelEntity.getCreatedTime() );
        subjectLabelBo.setUpdateBy( subjectLabelEntity.getUpdateBy() );
        subjectLabelBo.setUpdateTime( subjectLabelEntity.getUpdateTime() );
        subjectLabelBo.setIsDeleted( subjectLabelEntity.getIsDeleted() );

        return subjectLabelBo;
    }
}
