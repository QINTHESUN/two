package com.cp.subject.domain.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.subject.common.entity.PageResult;
import com.cp.subject.domain.bo.SubjectInfoBo;
import com.cp.subject.infra.basic.entity.SubjectInfoEntity;
import com.cp.subject.infra.basic.entity.SubjectInfoEs;

import java.util.List;

/**
 * 题目信息表(SubjectInfo)表服务接口
 * 
 * @author makejava
 * @since 2024-10-22 20:09:52
 */
public interface SubjectInfoDomainService  {

    /**
     * 新增题目
     * @param subjectInfoBo
     */
    void add(SubjectInfoBo subjectInfoBo);

    /**
     * 分页查询题目列表
     * @param subjectInfoBo
     * @return
     */
    PageResult<SubjectInfoBo> getSubjectPage(SubjectInfoBo subjectInfoBo);


    /**
     * 根据id查询题目详情
     * @param subjectInfoBo
     * @return
     */
    SubjectInfoBo getSubjectInfo(SubjectInfoBo subjectInfoBo);

    /**
     * es关键词搜索
     * @param subjectInfoBo
     * @return
     */
    PageResult<SubjectInfoEs> querySubjectBySearch(SubjectInfoBo subjectInfoBo);

    /**
     * 获取贡献榜
     * @return
     */
    List<SubjectInfoBo> getContributeList();

    Boolean del(SubjectInfoBo subjectInfoBo);

}
