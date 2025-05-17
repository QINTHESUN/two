package com.cp.subject.domain.handler.subject;

import com.cp.subject.common.enums.IsDeletedFlagEnum;
import com.cp.subject.common.enums.SubjectInfoTypeEnum;
import com.cp.subject.domain.bo.SubjectAnswerBo;
import com.cp.subject.domain.bo.SubjectInfoBo;
import com.cp.subject.domain.bo.SubjectOptionBo;
import com.cp.subject.domain.convert.SubjectJudgeBoConvert;
import com.cp.subject.infra.basic.entity.SubjectJudgeEntity;
import com.cp.subject.infra.basic.service.impl.SubjectJudgeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 判断题策略类
 *
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/23 上午11:38
 **/
@Component
public class JudgeTypeHandler implements SubjectTypeHandler{

    @Resource
    private JudgeTypeHandler judgeTypeHandler;

    @Autowired
    private SubjectJudgeServiceImpl subjectJudgeService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBo subjectInfoBO) {
        SubjectJudgeEntity subjectJudgeEntity = new SubjectJudgeEntity();
        SubjectAnswerBo subjectAnswerBo = subjectInfoBO.getOptionList().get(0);
        subjectJudgeEntity.setSubjectId(subjectInfoBO.getId());
        subjectJudgeEntity.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectJudgeEntity.setIsCorrect(subjectAnswerBo.getIsCorrect());
        subjectJudgeService.save(subjectJudgeEntity);
    }

    @Override
    public SubjectOptionBo query(int subjectId) {
        List<SubjectJudgeEntity> subjectJudgeEntityList =
                subjectJudgeService.queryBySubjectId(subjectId);
        List<SubjectAnswerBo> subjectAnswerBoList = SubjectJudgeBoConvert.INSTANCE.convertEntityToBoList(subjectJudgeEntityList);
        SubjectOptionBo subjectOptionBo = new SubjectOptionBo();
        subjectOptionBo.setOptionList(subjectAnswerBoList);
        return subjectOptionBo;
    }
}
