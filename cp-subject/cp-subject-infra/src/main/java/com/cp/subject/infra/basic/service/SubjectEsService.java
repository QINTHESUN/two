package com.cp.subject.infra.basic.service;

import com.cp.subject.common.entity.PageResult;
import com.cp.subject.infra.basic.entity.SubjectInfoEs;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/11/2 下午3:07
 **/
public interface SubjectEsService {

    boolean insert(SubjectInfoEs subjectInfoEs);

    PageResult<SubjectInfoEs> querySubjectList(SubjectInfoEs subjectInfoEs);


}
