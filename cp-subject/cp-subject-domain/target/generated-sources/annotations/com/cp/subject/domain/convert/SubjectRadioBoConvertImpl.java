package com.cp.subject.domain.convert;

import com.cp.subject.domain.bo.SubjectAnswerBo;
import com.cp.subject.infra.basic.entity.SubjectRadioEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:17:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class SubjectRadioBoConvertImpl implements SubjectRadioBoConvert {

    @Override
    public SubjectRadioEntity convertBoToEntity(SubjectAnswerBo subjectAnswerBo) {
        if ( subjectAnswerBo == null ) {
            return null;
        }

        SubjectRadioEntity subjectRadioEntity = new SubjectRadioEntity();

        subjectRadioEntity.setOptionType( subjectAnswerBo.getOptionType() );
        subjectRadioEntity.setOptionContent( subjectAnswerBo.getOptionContent() );
        subjectRadioEntity.setIsCorrect( subjectAnswerBo.getIsCorrect() );

        return subjectRadioEntity;
    }

    @Override
    public List<SubjectAnswerBo> convertEntityToBoList(List<SubjectRadioEntity> subjectRadioEntities) {
        if ( subjectRadioEntities == null ) {
            return null;
        }

        List<SubjectAnswerBo> list = new ArrayList<SubjectAnswerBo>( subjectRadioEntities.size() );
        for ( SubjectRadioEntity subjectRadioEntity : subjectRadioEntities ) {
            list.add( subjectRadioEntityToSubjectAnswerBo( subjectRadioEntity ) );
        }

        return list;
    }

    protected SubjectAnswerBo subjectRadioEntityToSubjectAnswerBo(SubjectRadioEntity subjectRadioEntity) {
        if ( subjectRadioEntity == null ) {
            return null;
        }

        SubjectAnswerBo subjectAnswerBo = new SubjectAnswerBo();

        subjectAnswerBo.setOptionType( subjectRadioEntity.getOptionType() );
        subjectAnswerBo.setOptionContent( subjectRadioEntity.getOptionContent() );
        subjectAnswerBo.setIsCorrect( subjectRadioEntity.getIsCorrect() );

        return subjectAnswerBo;
    }
}
