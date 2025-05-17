package com.cp.subject.domain.convert;

import com.cp.subject.domain.bo.SubjectAnswerBo;
import com.cp.subject.infra.basic.entity.SubjectMultipleEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:17:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class SubjectMultipleBoConvertImpl implements SubjectMultipleBoConvert {

    @Override
    public SubjectMultipleEntity convertBoToEntity(SubjectAnswerBo subjectAnswerBo) {
        if ( subjectAnswerBo == null ) {
            return null;
        }

        SubjectMultipleEntity subjectMultipleEntity = new SubjectMultipleEntity();

        if ( subjectAnswerBo.getOptionType() != null ) {
            subjectMultipleEntity.setOptionType( subjectAnswerBo.getOptionType().longValue() );
        }
        subjectMultipleEntity.setOptionContent( subjectAnswerBo.getOptionContent() );
        subjectMultipleEntity.setIsCorrect( subjectAnswerBo.getIsCorrect() );

        return subjectMultipleEntity;
    }

    @Override
    public List<SubjectAnswerBo> convertEntityToBoList(List<SubjectMultipleEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SubjectAnswerBo> list1 = new ArrayList<SubjectAnswerBo>( list.size() );
        for ( SubjectMultipleEntity subjectMultipleEntity : list ) {
            list1.add( subjectMultipleEntityToSubjectAnswerBo( subjectMultipleEntity ) );
        }

        return list1;
    }

    protected SubjectAnswerBo subjectMultipleEntityToSubjectAnswerBo(SubjectMultipleEntity subjectMultipleEntity) {
        if ( subjectMultipleEntity == null ) {
            return null;
        }

        SubjectAnswerBo subjectAnswerBo = new SubjectAnswerBo();

        if ( subjectMultipleEntity.getOptionType() != null ) {
            subjectAnswerBo.setOptionType( subjectMultipleEntity.getOptionType().intValue() );
        }
        subjectAnswerBo.setOptionContent( subjectMultipleEntity.getOptionContent() );
        subjectAnswerBo.setIsCorrect( subjectMultipleEntity.getIsCorrect() );

        return subjectAnswerBo;
    }
}
