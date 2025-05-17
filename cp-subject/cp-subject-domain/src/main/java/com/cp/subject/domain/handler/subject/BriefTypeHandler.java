package com.cp.subject.domain.handler.subject;

import com.cp.subject.common.enums.IsDeletedFlagEnum;
import com.cp.subject.common.enums.SubjectInfoTypeEnum;
import com.cp.subject.domain.bo.SubjectInfoBo;
import com.cp.subject.domain.bo.SubjectOptionBo;
import com.cp.subject.domain.convert.SubjectBriefBoConvert;
import com.cp.subject.infra.basic.entity.SubjectBriefEntity;
import com.cp.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 简答题的策略类
 *
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/23 上午10:05
 **/
@Component
public class BriefTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectBriefService subjectBriefService;


    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBo subjectInfoBO) {
        SubjectBriefEntity subjectBriefEntity =
                SubjectBriefBoConvert.INSTANCE.convertBoToEntity(subjectInfoBO);
        subjectBriefEntity.setSubjectId(subjectInfoBO.getId());
        subjectBriefEntity.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectBriefService.save(subjectBriefEntity);
    }

    @Override
    public SubjectOptionBo query(int subjectId) {
        SubjectBriefEntity subjectBriefEntity = new SubjectBriefEntity();
        subjectBriefEntity.setSubjectId((long) subjectId);
        SubjectBriefEntity result = subjectBriefService.queryBySubjectId(subjectBriefEntity);
        SubjectOptionBo subjectOptionBo = new SubjectOptionBo();
        subjectOptionBo.setSubjectAnswer(result.getSubjectAnswer());
        return subjectOptionBo;
    }
}
