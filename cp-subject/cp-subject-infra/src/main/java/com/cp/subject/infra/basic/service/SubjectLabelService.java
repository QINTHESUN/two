package com.cp.subject.infra.basic.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.subject.infra.basic.entity.SubjectLabelEntity;

import java.util.List;

/**
 * 题目标签表(SubjectLabel)表服务接口
 * 
 * @author makejava
 * @since 2024-10-22 14:19:42
 */
public interface SubjectLabelService extends IService<SubjectLabelEntity> {

    /**
     * 添加分类标签
     * @param subjectLabelEntity
     * @return
     */
    Boolean add(SubjectLabelEntity subjectLabelEntity);


    /**
     * 修改分类标签
     * @param subjectLabelEntity
     * @return
     */
    Boolean update(SubjectLabelEntity subjectLabelEntity);


    /**
     * 删除分类标签
     * @param subjectLabelEntity
     * @return
     */
    Boolean delete(SubjectLabelEntity subjectLabelEntity);

    /**
     * 根据分类id查询所有的标签
     * @param subjectLabelEntity
     * @return
     */
    List<SubjectLabelEntity> queryCondition(SubjectLabelEntity subjectLabelEntity);

    /**
     * 根据标签id获取所有的标签
     * @param labelList
     * @return
     */
    List<SubjectLabelEntity> selectBath(List<Long> labelList);


    /**
     * 根据 labelList查询标签
     * @param labelList
     * @return
     */
    List<SubjectLabelEntity> queryByLabelList(List<Long> labelList);
}
