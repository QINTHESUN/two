package com.cp.subject.infra.basic.service;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.subject.infra.basic.entity.SubjectJudgeEntity;

/**
 * 判断题(SubjectJudge)表服务接口
 * 
 * @author makejava
 * @since 2024-10-22 20:12:39
 */
public interface SubjectJudgeService extends IService<SubjectJudgeEntity> {

    /**
     * 根据subjectId查询所有的判断题
     * @param subjectId
     * @return
     */
    List<SubjectJudgeEntity> queryBySubjectId(int subjectId);
}
