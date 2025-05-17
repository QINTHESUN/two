package com.cp.subject.infra.basic.service;
import java.util.Date;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.subject.infra.basic.entity.SubjectBriefEntity;

/**
 * 简答题(SubjectBrief)表服务接口
 * 
 * @author makejava
 * @since 2024-10-22 20:10:39
 */
public interface SubjectBriefService extends IService<SubjectBriefEntity> {

    /**
     *
     * 根据subjectId查询简答题目
     * @param
     * @return
     */
    SubjectBriefEntity queryBySubjectId(SubjectBriefEntity subjectBriefEntity);
}
