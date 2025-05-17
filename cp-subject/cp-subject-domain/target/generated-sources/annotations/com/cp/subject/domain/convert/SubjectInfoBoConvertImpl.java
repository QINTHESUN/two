package com.cp.subject.domain.convert;

import com.cp.subject.domain.bo.SubjectAnswerBo;
import com.cp.subject.domain.bo.SubjectInfoBo;
import com.cp.subject.domain.bo.SubjectOptionBo;
import com.cp.subject.infra.basic.entity.SubjectInfoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:17:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class SubjectInfoBoConvertImpl implements SubjectInfoBoConvert {

    @Override
    public SubjectInfoEntity convertBoToEntity(SubjectInfoBo subjectInfoBo) {
        if ( subjectInfoBo == null ) {
            return null;
        }

        SubjectInfoEntity subjectInfoEntity = new SubjectInfoEntity();

        subjectInfoEntity.setId( subjectInfoBo.getId() );
        subjectInfoEntity.setSubjectName( subjectInfoBo.getSubjectName() );
        subjectInfoEntity.setSubjectDifficult( subjectInfoBo.getSubjectDifficult() );
        subjectInfoEntity.setSettleName( subjectInfoBo.getSettleName() );
        subjectInfoEntity.setSubjectType( subjectInfoBo.getSubjectType() );
        subjectInfoEntity.setSubjectScore( subjectInfoBo.getSubjectScore() );
        subjectInfoEntity.setSubjectParse( subjectInfoBo.getSubjectParse() );
        subjectInfoEntity.setCreatedBy( subjectInfoBo.getCreatedBy() );
        subjectInfoEntity.setCreatedTime( subjectInfoBo.getCreatedTime() );
        subjectInfoEntity.setUpdateBy( subjectInfoBo.getUpdateBy() );
        subjectInfoEntity.setUpdateTime( subjectInfoBo.getUpdateTime() );
        subjectInfoEntity.setIsDeleted( subjectInfoBo.getIsDeleted() );

        return subjectInfoEntity;
    }

    @Override
    public List<SubjectInfoBo> convertEntityToBoList(List<SubjectInfoEntity> subjectInfoEntities) {
        if ( subjectInfoEntities == null ) {
            return null;
        }

        List<SubjectInfoBo> list = new ArrayList<SubjectInfoBo>( subjectInfoEntities.size() );
        for ( SubjectInfoEntity subjectInfoEntity : subjectInfoEntities ) {
            list.add( subjectInfoEntityToSubjectInfoBo( subjectInfoEntity ) );
        }

        return list;
    }

    @Override
    public SubjectInfoBo convertBo(SubjectOptionBo subjectOptionBo, SubjectInfoEntity subjectInfoEntity) {
        if ( subjectOptionBo == null && subjectInfoEntity == null ) {
            return null;
        }

        SubjectInfoBo subjectInfoBo = new SubjectInfoBo();

        if ( subjectOptionBo != null ) {
            subjectInfoBo.setSubjectAnswer( subjectOptionBo.getSubjectAnswer() );
            List<SubjectAnswerBo> list = subjectOptionBo.getOptionList();
            if ( list != null ) {
                subjectInfoBo.setOptionList( new ArrayList<SubjectAnswerBo>( list ) );
            }
        }
        if ( subjectInfoEntity != null ) {
            subjectInfoBo.setId( subjectInfoEntity.getId() );
            subjectInfoBo.setSubjectName( subjectInfoEntity.getSubjectName() );
            subjectInfoBo.setSubjectDifficult( subjectInfoEntity.getSubjectDifficult() );
            subjectInfoBo.setSettleName( subjectInfoEntity.getSettleName() );
            subjectInfoBo.setSubjectType( subjectInfoEntity.getSubjectType() );
            subjectInfoBo.setSubjectScore( subjectInfoEntity.getSubjectScore() );
            subjectInfoBo.setSubjectParse( subjectInfoEntity.getSubjectParse() );
            subjectInfoBo.setCreatedBy( subjectInfoEntity.getCreatedBy() );
            subjectInfoBo.setCreatedTime( subjectInfoEntity.getCreatedTime() );
            subjectInfoBo.setUpdateBy( subjectInfoEntity.getUpdateBy() );
            subjectInfoBo.setUpdateTime( subjectInfoEntity.getUpdateTime() );
            subjectInfoBo.setIsDeleted( subjectInfoEntity.getIsDeleted() );
        }

        return subjectInfoBo;
    }

    protected SubjectInfoBo subjectInfoEntityToSubjectInfoBo(SubjectInfoEntity subjectInfoEntity) {
        if ( subjectInfoEntity == null ) {
            return null;
        }

        SubjectInfoBo subjectInfoBo = new SubjectInfoBo();

        subjectInfoBo.setId( subjectInfoEntity.getId() );
        subjectInfoBo.setSubjectName( subjectInfoEntity.getSubjectName() );
        subjectInfoBo.setSubjectDifficult( subjectInfoEntity.getSubjectDifficult() );
        subjectInfoBo.setSettleName( subjectInfoEntity.getSettleName() );
        subjectInfoBo.setSubjectType( subjectInfoEntity.getSubjectType() );
        subjectInfoBo.setSubjectScore( subjectInfoEntity.getSubjectScore() );
        subjectInfoBo.setSubjectParse( subjectInfoEntity.getSubjectParse() );
        subjectInfoBo.setCreatedBy( subjectInfoEntity.getCreatedBy() );
        subjectInfoBo.setCreatedTime( subjectInfoEntity.getCreatedTime() );
        subjectInfoBo.setUpdateBy( subjectInfoEntity.getUpdateBy() );
        subjectInfoBo.setUpdateTime( subjectInfoEntity.getUpdateTime() );
        subjectInfoBo.setIsDeleted( subjectInfoEntity.getIsDeleted() );

        return subjectInfoBo;
    }
}
