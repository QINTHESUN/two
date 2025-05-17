package com.cp.subject.application.convert;

import com.cp.subject.application.dto.SubjectLabelDto;
import com.cp.subject.domain.bo.SubjectLabelBo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:17:12+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class SubjectLabelDtoConvertImpl implements SubjectLabelDtoConvert {

    @Override
    public SubjectLabelBo convertDtoToBo(SubjectLabelDto dto) {
        if ( dto == null ) {
            return null;
        }

        SubjectLabelBo subjectLabelBo = new SubjectLabelBo();

        subjectLabelBo.setId( dto.getId() );
        subjectLabelBo.setLabelName( dto.getLabelName() );
        subjectLabelBo.setSortNum( dto.getSortNum() );
        subjectLabelBo.setCategoryId( dto.getCategoryId() );
        subjectLabelBo.setCreatedBy( dto.getCreatedBy() );
        subjectLabelBo.setCreatedTime( dto.getCreatedTime() );
        subjectLabelBo.setUpdateBy( dto.getUpdateBy() );
        subjectLabelBo.setUpdateTime( dto.getUpdateTime() );
        subjectLabelBo.setIsDeleted( dto.getIsDeleted() );

        return subjectLabelBo;
    }

    @Override
    public List<SubjectLabelDto> convertBoListToDtoList(List<SubjectLabelBo> boList) {
        if ( boList == null ) {
            return null;
        }

        List<SubjectLabelDto> list = new ArrayList<SubjectLabelDto>( boList.size() );
        for ( SubjectLabelBo subjectLabelBo : boList ) {
            list.add( subjectLabelBoToSubjectLabelDto( subjectLabelBo ) );
        }

        return list;
    }

    protected SubjectLabelDto subjectLabelBoToSubjectLabelDto(SubjectLabelBo subjectLabelBo) {
        if ( subjectLabelBo == null ) {
            return null;
        }

        SubjectLabelDto subjectLabelDto = new SubjectLabelDto();

        subjectLabelDto.setId( subjectLabelBo.getId() );
        subjectLabelDto.setLabelName( subjectLabelBo.getLabelName() );
        subjectLabelDto.setSortNum( subjectLabelBo.getSortNum() );
        subjectLabelDto.setCategoryId( subjectLabelBo.getCategoryId() );
        subjectLabelDto.setCreatedBy( subjectLabelBo.getCreatedBy() );
        subjectLabelDto.setCreatedTime( subjectLabelBo.getCreatedTime() );
        subjectLabelDto.setUpdateBy( subjectLabelBo.getUpdateBy() );
        subjectLabelDto.setUpdateTime( subjectLabelBo.getUpdateTime() );
        subjectLabelDto.setIsDeleted( subjectLabelBo.getIsDeleted() );

        return subjectLabelDto;
    }
}
