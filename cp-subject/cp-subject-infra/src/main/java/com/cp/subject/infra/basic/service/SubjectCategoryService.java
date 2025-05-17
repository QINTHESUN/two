package com.cp.subject.infra.basic.service;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.subject.infra.basic.entity.SubjectCategoryEntity;

/**
 * 题目分类(SubjectCategory)表服务接口
 * 
 * @author makejava
 * @since 2024-10-22 02:49:43
 */
public interface SubjectCategoryService extends IService<SubjectCategoryEntity> {

    /**
     * 添加题目分类
     * @param subjectCategoryEntity
     * @return
     */
    Boolean add(SubjectCategoryEntity subjectCategoryEntity);


    /**
     * 修改题目分类
     * @param subjectCategoryEntity
     * @return
     */
    Boolean update(SubjectCategoryEntity subjectCategoryEntity);

    /**
     * 根据category_type查询题目分类
     * @param subjectCategoryEntity
     * @return
     */
    List<SubjectCategoryEntity> queryByType(SubjectCategoryEntity subjectCategoryEntity);

    /**
     *
     * @param id
     * @return
     */
    int queryCount(Long id);

    /**
     * 删除题目分类
     * @param subjectCategoryEntity
     * @return
     */
    Boolean delete(SubjectCategoryEntity subjectCategoryEntity);

    /**
     * 根据分类id查找分类类型
     * @param categoryId
     * @return
     */
    SubjectCategoryEntity queryCategoryType(String categoryId);


    /**
     * 查询分类
     * @param categoryId
     * @return
     */
    List<SubjectCategoryEntity> queryCategory(Long categoryId);

    List<SubjectCategoryEntity> queryAll(int code);
}
