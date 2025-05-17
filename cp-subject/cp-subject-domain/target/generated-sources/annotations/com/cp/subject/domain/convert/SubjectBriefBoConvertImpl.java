package com.cp.subject.domain.convert;

import com.cp.subject.domain.bo.SubjectInfoBo;
import com.cp.subject.infra.basic.entity.SubjectBriefEntity;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:17:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class SubjectBriefBoConvertImpl implements SubjectBriefBoConvert {

    @Override
    public SubjectBriefEntity convertBoToEntity(SubjectInfoBo bo) {
        if ( bo == null ) {
            return null;
        }

        SubjectBriefEntity subjectBriefEntity = new SubjectBriefEntity();

        subjectBriefEntity.setId( bo.getId() );
        subjectBriefEntity.setSubjectAnswer( bo.getSubjectAnswer() );
        subjectBriefEntity.setCreatedBy( bo.getCreatedBy() );
        subjectBriefEntity.setCreatedTime( bo.getCreatedTime() );
        subjectBriefEntity.setUpdateBy( bo.getUpdateBy() );
        subjectBriefEntity.setUpdateTime( bo.getUpdateTime() );
        subjectBriefEntity.setIsDeleted( bo.getIsDeleted() );

        return subjectBriefEntity;
    }
}
