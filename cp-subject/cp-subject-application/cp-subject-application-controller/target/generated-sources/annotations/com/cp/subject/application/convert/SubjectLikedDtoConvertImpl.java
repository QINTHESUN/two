package com.cp.subject.application.convert;

import com.cp.subject.application.dto.SubjectLikedDto;
import com.cp.subject.domain.bo.SubjectLikedBo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:17:12+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class SubjectLikedDtoConvertImpl implements SubjectLikedDtoConvert {

    @Override
    public SubjectLikedBo convertDtoToBo(SubjectLikedDto dto) {
        if ( dto == null ) {
            return null;
        }

        SubjectLikedBo subjectLikedBo = new SubjectLikedBo();

        subjectLikedBo.setPageNo( dto.getPageNo() );
        subjectLikedBo.setPageSize( dto.getPageSize() );
        subjectLikedBo.setSubjectName( dto.getSubjectName() );
        subjectLikedBo.setId( dto.getId() );
        subjectLikedBo.setSubjectId( dto.getSubjectId() );
        subjectLikedBo.setLikeUserId( dto.getLikeUserId() );
        subjectLikedBo.setStatus( dto.getStatus() );
        subjectLikedBo.setCreatedBy( dto.getCreatedBy() );
        subjectLikedBo.setCreatedTime( dto.getCreatedTime() );
        subjectLikedBo.setUpdateBy( dto.getUpdateBy() );
        subjectLikedBo.setUpdateTime( dto.getUpdateTime() );
        subjectLikedBo.setIsDeleted( dto.getIsDeleted() );

        return subjectLikedBo;
    }
}
