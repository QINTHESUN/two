package com.cp.subject.infra.basic.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 题目分类(SubjectCategory)表实体类
 * 
 * @author makejava
 * @since 2024-10-22 02:49:44
 */

@Data
@TableName("subject_category")
public class SubjectCategoryEntity  implements Serializable {
    private static final long serialVersionUID = -38496298930537856L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类类型
     */
    private Integer categoryType;

    /**
     * 图标连接
     */
    private String imageUrl;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除 0: 未删除 1: 已删除
     */
    private Integer isDeleted;

}

