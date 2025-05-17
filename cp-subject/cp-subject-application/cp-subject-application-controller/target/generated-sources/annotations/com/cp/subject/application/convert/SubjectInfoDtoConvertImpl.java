package com.cp.subject.application.convert;

import com.cp.subject.application.dto.SubjectAnswerDto;
import com.cp.subject.application.dto.SubjectInfoDto;
import com.cp.subject.domain.bo.SubjectAnswerBo;
import com.cp.subject.domain.bo.SubjectInfoBo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:17:12+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class SubjectInfoDtoConvertImpl implements SubjectInfoDtoConvert {

    @Override
    public SubjectInfoBo convertDtoToBo(SubjectInfoDto dto) {
        if ( dto == null ) {
            return null;
        }

        SubjectInfoBo subjectInfoBo = new SubjectInfoBo();

        subjectInfoBo.setPageNo( dto.getPageNo() );
        subjectInfoBo.setPageSize( dto.getPageSize() );
        subjectInfoBo.setId( dto.getId() );
        subjectInfoBo.setSubjectName( dto.getSubjectName() );
        subjectInfoBo.setSubjectDifficult( dto.getSubjectDifficult() );
        subjectInfoBo.setSettleName( dto.getSettleName() );
        subjectInfoBo.setSubjectType( dto.getSubjectType() );
        subjectInfoBo.setSubjectScore( dto.getSubjectScore() );
        subjectInfoBo.setSubjectParse( dto.getSubjectParse() );
        subjectInfoBo.setSubjectAnswer( dto.getSubjectAnswer() );
        List<Integer> list = dto.getCategoryIds();
        if ( list != null ) {
            subjectInfoBo.setCategoryIds( new ArrayList<Integer>( list ) );
        }
        List<Integer> list1 = dto.getLabelIds();
        if ( list1 != null ) {
            subjectInfoBo.setLabelIds( new ArrayList<Integer>( list1 ) );
        }
        subjectInfoBo.setOptionList( subjectAnswerDtoToBoList( dto.getOptionList() ) );
        List<String> list3 = dto.getLabelName();
        if ( list3 != null ) {
            subjectInfoBo.setLabelName( new ArrayList<String>( list3 ) );
        }
        subjectInfoBo.setCategoryId( dto.getCategoryId() );
        subjectInfoBo.setLabelId( dto.getLabelId() );
        subjectInfoBo.setKeyWord( dto.getKeyWord() );
        subjectInfoBo.setCreateUser( dto.getCreateUser() );
        subjectInfoBo.setCreateUserAvatar( dto.getCreateUserAvatar() );
        subjectInfoBo.setSubjectCount( dto.getSubjectCount() );
        subjectInfoBo.setLiked( dto.getLiked() );
        subjectInfoBo.setLikedCount( dto.getLikedCount() );
        subjectInfoBo.setNextSubjectId( dto.getNextSubjectId() );
        subjectInfoBo.setLastSubjectId( dto.getLastSubjectId() );
        subjectInfoBo.setCreatedBy( dto.getCreatedBy() );
        subjectInfoBo.setCreatedTime( dto.getCreatedTime() );
        subjectInfoBo.setUpdateBy( dto.getUpdateBy() );
        subjectInfoBo.setUpdateTime( dto.getUpdateTime() );
        subjectInfoBo.setIsDeleted( dto.getIsDeleted() );

        return subjectInfoBo;
    }

    @Override
    public SubjectInfoDto convertBoToDto(SubjectInfoBo bo) {
        if ( bo == null ) {
            return null;
        }

        SubjectInfoDto subjectInfoDto = new SubjectInfoDto();

        subjectInfoDto.setPageNo( bo.getPageNo() );
        subjectInfoDto.setPageSize( bo.getPageSize() );
        subjectInfoDto.setId( bo.getId() );
        subjectInfoDto.setSubjectName( bo.getSubjectName() );
        subjectInfoDto.setSubjectDifficult( bo.getSubjectDifficult() );
        subjectInfoDto.setSettleName( bo.getSettleName() );
        subjectInfoDto.setSubjectType( bo.getSubjectType() );
        subjectInfoDto.setSubjectScore( bo.getSubjectScore() );
        subjectInfoDto.setSubjectParse( bo.getSubjectParse() );
        subjectInfoDto.setSubjectAnswer( bo.getSubjectAnswer() );
        List<Integer> list = bo.getCategoryIds();
        if ( list != null ) {
            subjectInfoDto.setCategoryIds( new ArrayList<Integer>( list ) );
        }
        List<Integer> list1 = bo.getLabelIds();
        if ( list1 != null ) {
            subjectInfoDto.setLabelIds( new ArrayList<Integer>( list1 ) );
        }
        subjectInfoDto.setOptionList( subjectAnswerBoListToSubjectAnswerDtoList( bo.getOptionList() ) );
        List<String> list3 = bo.getLabelName();
        if ( list3 != null ) {
            subjectInfoDto.setLabelName( new ArrayList<String>( list3 ) );
        }
        subjectInfoDto.setCategoryId( bo.getCategoryId() );
        subjectInfoDto.setLabelId( bo.getLabelId() );
        subjectInfoDto.setKeyWord( bo.getKeyWord() );
        subjectInfoDto.setCreateUser( bo.getCreateUser() );
        subjectInfoDto.setCreateUserAvatar( bo.getCreateUserAvatar() );
        subjectInfoDto.setSubjectCount( bo.getSubjectCount() );
        subjectInfoDto.setLiked( bo.getLiked() );
        subjectInfoDto.setLikedCount( bo.getLikedCount() );
        subjectInfoDto.setNextSubjectId( bo.getNextSubjectId() );
        subjectInfoDto.setLastSubjectId( bo.getLastSubjectId() );
        subjectInfoDto.setCreatedBy( bo.getCreatedBy() );
        subjectInfoDto.setCreatedTime( bo.getCreatedTime() );
        subjectInfoDto.setUpdateBy( bo.getUpdateBy() );
        subjectInfoDto.setUpdateTime( bo.getUpdateTime() );
        subjectInfoDto.setIsDeleted( bo.getIsDeleted() );

        return subjectInfoDto;
    }

    @Override
    public List<SubjectAnswerBo> subjectAnswerDtoToBoList(List<SubjectAnswerDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<SubjectAnswerBo> list = new ArrayList<SubjectAnswerBo>( dtoList.size() );
        for ( SubjectAnswerDto subjectAnswerDto : dtoList ) {
            list.add( subjectAnswerDtoToSubjectAnswerBo( subjectAnswerDto ) );
        }

        return list;
    }

    @Override
    public List<SubjectInfoDto> convertBoListToDtoList(List<SubjectInfoBo> boList) {
        if ( boList == null ) {
            return null;
        }

        List<SubjectInfoDto> list = new ArrayList<SubjectInfoDto>( boList.size() );
        for ( SubjectInfoBo subjectInfoBo : boList ) {
            list.add( convertBoToDto( subjectInfoBo ) );
        }

        return list;
    }

    protected SubjectAnswerDto subjectAnswerBoToSubjectAnswerDto(SubjectAnswerBo subjectAnswerBo) {
        if ( subjectAnswerBo == null ) {
            return null;
        }

        SubjectAnswerDto subjectAnswerDto = new SubjectAnswerDto();

        subjectAnswerDto.setOptionType( subjectAnswerBo.getOptionType() );
        subjectAnswerDto.setOptionContent( subjectAnswerBo.getOptionContent() );
        subjectAnswerDto.setIsCorrect( subjectAnswerBo.getIsCorrect() );

        return subjectAnswerDto;
    }

    protected List<SubjectAnswerDto> subjectAnswerBoListToSubjectAnswerDtoList(List<SubjectAnswerBo> list) {
        if ( list == null ) {
            return null;
        }

        List<SubjectAnswerDto> list1 = new ArrayList<SubjectAnswerDto>( list.size() );
        for ( SubjectAnswerBo subjectAnswerBo : list ) {
            list1.add( subjectAnswerBoToSubjectAnswerDto( subjectAnswerBo ) );
        }

        return list1;
    }

    protected SubjectAnswerBo subjectAnswerDtoToSubjectAnswerBo(SubjectAnswerDto subjectAnswerDto) {
        if ( subjectAnswerDto == null ) {
            return null;
        }

        SubjectAnswerBo subjectAnswerBo = new SubjectAnswerBo();

        subjectAnswerBo.setOptionType( subjectAnswerDto.getOptionType() );
        subjectAnswerBo.setOptionContent( subjectAnswerDto.getOptionContent() );
        subjectAnswerBo.setIsCorrect( subjectAnswerDto.getIsCorrect() );

        return subjectAnswerBo;
    }
}
