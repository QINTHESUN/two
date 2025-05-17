package com.cp.subject.application.convert;

import com.cp.subject.application.dto.SubjectCategoryDto;
import com.cp.subject.domain.bo.SubjectCategoryBo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:17:12+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class SubjectCategoryDtoConvertImpl implements SubjectCategoryDtoConvert {

    @Override
    public SubjectCategoryBo convertDtoToBo(SubjectCategoryDto dto) {
        if ( dto == null ) {
            return null;
        }

        SubjectCategoryBo subjectCategoryBo = new SubjectCategoryBo();

        subjectCategoryBo.setId( dto.getId() );
        subjectCategoryBo.setCategoryName( dto.getCategoryName() );
        subjectCategoryBo.setCategoryType( dto.getCategoryType() );
        subjectCategoryBo.setImageUrl( dto.getImageUrl() );
        subjectCategoryBo.setParentId( dto.getParentId() );
        subjectCategoryBo.setCount( dto.getCount() );
        subjectCategoryBo.setCreatedBy( dto.getCreatedBy() );
        subjectCategoryBo.setCreatedTime( dto.getCreatedTime() );
        subjectCategoryBo.setUpdateBy( dto.getUpdateBy() );
        subjectCategoryBo.setUpdateTime( dto.getUpdateTime() );
        subjectCategoryBo.setIsDeleted( dto.getIsDeleted() );

        return subjectCategoryBo;
    }

    @Override
    public SubjectCategoryDto convertBoToDto(SubjectCategoryBo bo) {
        if ( bo == null ) {
            return null;
        }

        SubjectCategoryDto subjectCategoryDto = new SubjectCategoryDto();

        subjectCategoryDto.setId( bo.getId() );
        subjectCategoryDto.setCategoryName( bo.getCategoryName() );
        subjectCategoryDto.setCategoryType( bo.getCategoryType() );
        subjectCategoryDto.setImageUrl( bo.getImageUrl() );
        subjectCategoryDto.setParentId( bo.getParentId() );
        subjectCategoryDto.setCount( bo.getCount() );
        subjectCategoryDto.setCreatedBy( bo.getCreatedBy() );
        subjectCategoryDto.setCreatedTime( bo.getCreatedTime() );
        subjectCategoryDto.setUpdateBy( bo.getUpdateBy() );
        subjectCategoryDto.setUpdateTime( bo.getUpdateTime() );
        subjectCategoryDto.setIsDeleted( bo.getIsDeleted() );

        return subjectCategoryDto;
    }

    @Override
    public List<SubjectCategoryDto> convertBoToDtoList(List<SubjectCategoryBo> boList) {
        if ( boList == null ) {
            return null;
        }

        List<SubjectCategoryDto> list = new ArrayList<SubjectCategoryDto>( boList.size() );
        for ( SubjectCategoryBo subjectCategoryBo : boList ) {
            list.add( convertBoToDto( subjectCategoryBo ) );
        }

        return list;
    }
}
