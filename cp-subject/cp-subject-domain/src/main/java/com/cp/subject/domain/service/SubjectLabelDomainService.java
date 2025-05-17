package com.cp.subject.domain.service;
import com.cp.subject.domain.bo.SubjectLabelBo;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * 题目标签表(SubjectLabel)表服务接口
 * 
 * @author makejava
 * @since 2024-10-22 14:19:42
 */
public interface SubjectLabelDomainService {

    /**
     * 添加标签信息
     * @param subjectLabelBo
     * @return
     */
    Boolean add(SubjectLabelBo subjectLabelBo);

    /**
     * 修改分类标签
     * @param subjectLabelBo
     * @return
     */
    Boolean update(SubjectLabelBo subjectLabelBo);


    /**
     * 删除分类标签
     * @param subjectLabelBo
     * @return
     */
    Boolean delete(SubjectLabelBo subjectLabelBo);

    /**
     * 查询分类标签
     * @param subjectLabelBo
     * @return
     */
    List<SubjectLabelBo> queryByCategoryId(SubjectLabelBo subjectLabelBo);
}
