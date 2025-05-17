package com.cp.subject.domain.handler.subject;

import com.cp.subject.common.enums.IsDeletedFlagEnum;
import com.cp.subject.common.enums.SubjectInfoTypeEnum;
import com.cp.subject.domain.bo.SubjectAnswerBo;
import com.cp.subject.domain.bo.SubjectInfoBo;
import com.cp.subject.domain.bo.SubjectOptionBo;
import com.cp.subject.domain.convert.SubjectRadioBoConvert;
import com.cp.subject.infra.basic.entity.SubjectRadioEntity;
import com.cp.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 单选题的策略类
 *
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/23 上午11:16
 **/
@Component
public class RadioTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBo subjectInfoBO) {
        List<SubjectRadioEntity> subjectRadioEntityList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectRadioEntity subjectRadioEntity =
                    SubjectRadioBoConvert.INSTANCE.convertBoToEntity(option);
            subjectRadioEntity.setSubjectId(subjectInfoBO.getId());
            subjectRadioEntity.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            subjectRadioEntityList.add(subjectRadioEntity);
        });
        subjectRadioService.saveBatch(subjectRadioEntityList);

    }

    @Override
    public SubjectOptionBo query(int subjectId) {
        List<SubjectRadioEntity> subjectRadioEntityList =
                subjectRadioService.queryBySubjectId(subjectId);
        List<SubjectAnswerBo> subjectAnswerBoList = SubjectRadioBoConvert.INSTANCE.convertEntityToBoList(subjectRadioEntityList);
        SubjectOptionBo subjectOptionBo = new SubjectOptionBo();
        subjectOptionBo.setOptionList(subjectAnswerBoList);
        return subjectOptionBo;
    }
}
