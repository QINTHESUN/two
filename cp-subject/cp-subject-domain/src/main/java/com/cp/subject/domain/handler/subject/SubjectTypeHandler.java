package com.cp.subject.domain.handler.subject;

import com.cp.subject.common.enums.SubjectInfoTypeEnum;
import com.cp.subject.domain.bo.SubjectInfoBo;
import com.cp.subject.domain.bo.SubjectOptionBo;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/23 上午9:50
 **/
public interface SubjectTypeHandler {

    /**
     * 枚举身份的识别
     */
    SubjectInfoTypeEnum getHandlerType();

    /**
     * 实际的题目的插入
     */
    void add(SubjectInfoBo subjectInfoBO);

    /**
     * 实际的题目的插入
     */
    SubjectOptionBo query(int subjectId);



}
