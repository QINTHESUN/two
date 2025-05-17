package com.cp.subject.domain.convert;

import com.cp.subject.domain.bo.SubjectAnswerBo;
import com.cp.subject.infra.basic.entity.SubjectJudgeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:17:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class SubjectJudgeBoConvertImpl implements SubjectJudgeBoConvert {

    @Override
    public SubjectJudgeEntity convertBoToEntity(SubjectAnswerBo bo) {
        if ( bo == null ) {
            return null;
        }

        SubjectJudgeEntity subjectJudgeEntity = new SubjectJudgeEntity();

        subjectJudgeEntity.setIsCorrect( bo.getIsCorrect() );

        return subjectJudgeEntity;
    }

    @Override
    public List<SubjectAnswerBo> convertEntityToBoList(List<SubjectJudgeEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<SubjectAnswerBo> list = new ArrayList<SubjectAnswerBo>( entities.size() );
        for ( SubjectJudgeEntity subjectJudgeEntity : entities ) {
            list.add( subjectJudgeEntityToSubjectAnswerBo( subjectJudgeEntity ) );
        }

        return list;
    }

    protected SubjectAnswerBo subjectJudgeEntityToSubjectAnswerBo(SubjectJudgeEntity subjectJudgeEntity) {
        if ( subjectJudgeEntity == null ) {
            return null;
        }

        SubjectAnswerBo subjectAnswerBo = new SubjectAnswerBo();

        subjectAnswerBo.setIsCorrect( subjectJudgeEntity.getIsCorrect() );

        return subjectAnswerBo;
    }
}
