package com.cp.subject.infra.basic.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 简答题(SubjectBrief)表实体类
 * 
 * @author makejava
 * @since 2024-10-22 20:10:39
 */

@Data
@TableName("subject_brief")
public class SubjectBriefEntity  implements Serializable {
    private static final long serialVersionUID = 996783788638954905L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 题目id
     */
    private Long subjectId;

    /**
     * 题目答案
     */
    private String subjectAnswer;

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
     * 
     */
    private Integer isDeleted;

}

