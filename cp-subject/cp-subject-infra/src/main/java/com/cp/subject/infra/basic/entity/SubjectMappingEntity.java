package com.cp.subject.infra.basic.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 题目分类关系表(SubjectMapping)表实体类
 * 
 * @author makejava
 * @since 2024-10-22 17:26:41
 */

@Data
@TableName("subject_mapping")
public class SubjectMappingEntity  implements Serializable {
    private static final long serialVersionUID = 535739939546903650L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 题目id
     */
    private Long subjectId;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 标签id
     */
    private Long labelId;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer isDeleted;

}

