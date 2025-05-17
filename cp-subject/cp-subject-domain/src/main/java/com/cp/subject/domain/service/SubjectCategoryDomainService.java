package com.cp.subject.domain.service;
import com.cp.subject.domain.bo.SubjectCategoryBo;

import java.util.List;

/**
 * 题目分类(SubjectCategory)表服务接口
 * 
 * @author makejava
 * @since 2024-10-22 02:49:43
 */
public interface SubjectCategoryDomainService  {

    /**
     * 添加题目分类
     * @param subjectCategoryBo
     * @return
     */
    Boolean add(SubjectCategoryBo subjectCategoryBo);


    /**
     * 修改题目分类
     * @param subjectCategoryBo
     * @return
     */
    Boolean update(SubjectCategoryBo subjectCategoryBo);

    /**
     * 删除题目分类
     * @param subjectCategoryBo
     * @return
     */
    Boolean delete(SubjectCategoryBo subjectCategoryBo);

    /**
     * 根据category_type查询题目分类
     * @param subjectCategoryBo
     * @return
     */
    List<SubjectCategoryBo> queryByType(SubjectCategoryBo subjectCategoryBo);


    /**
     * 查询大类下分类
     * @param subjectCategoryBo
     * @return
     */
    List<SubjectCategoryBo> queryCategoryAndLabel(SubjectCategoryBo subjectCategoryBo);

    /**
     * 查询所有分类
     * @param code
     * @return
     */
    List<SubjectCategoryBo> queryAll(int code);
}
