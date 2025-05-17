package com.cp.subject.infra.basic.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * (Comments)表实体类
 * 
 * @author makejava
 * @since 2024-11-08 15:16:11
 */

@Data
@TableName("comments")
public class CommentsEntity  implements Serializable {
    private static final long serialVersionUID = -65760611159466789L;

    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long topicId;

    /**
     * 
     */
    private Long parentId;

    /**
     * 
     */
    private String userId;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private Date createdAt;

    /**
     * 
     */
    private Integer isDeleted;

}

