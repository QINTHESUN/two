package com.cp.subject.domain.handler.subject;

import com.cp.subject.common.enums.IsDeletedFlagEnum;
import com.cp.subject.common.enums.SubjectInfoTypeEnum;
import com.cp.subject.domain.bo.SubjectAnswerBo;
import com.cp.subject.domain.bo.SubjectInfoBo;
import com.cp.subject.domain.bo.SubjectOptionBo;
import com.cp.subject.domain.convert.SubjectMultipleBoConvert;
import com.cp.subject.infra.basic.entity.SubjectMultipleEntity;
import com.cp.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 多选题策略类
 *
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/23 上午11:31
 **/
@Component
public class MultipleTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectMultipleService subjectMultipleService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBo subjectInfoBO) {
        List<SubjectMultipleEntity> subjectMultipleEntityList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectMultipleEntity subjectMultipleEntity = SubjectMultipleBoConvert.INSTANCE.convertBoToEntity(option);
            subjectMultipleEntity.setSubjectId(subjectInfoBO.getId());
            subjectMultipleEntity.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            subjectMultipleEntityList.add(subjectMultipleEntity);
        });
        subjectMultipleService.saveBatch(subjectMultipleEntityList);
    }

    @Override
    public SubjectOptionBo query(int subjectId) {
        List<SubjectMultipleEntity> subjectMultipleEntityList =
                subjectMultipleService.queryBySubjectId(subjectId);
        List<SubjectAnswerBo> subjectAnswerBoList = SubjectMultipleBoConvert.INSTANCE.convertEntityToBoList(subjectMultipleEntityList);
        SubjectOptionBo subjectOptionBo = new SubjectOptionBo();
        subjectOptionBo.setOptionList(subjectAnswerBoList);
        return subjectOptionBo;
    }
}
