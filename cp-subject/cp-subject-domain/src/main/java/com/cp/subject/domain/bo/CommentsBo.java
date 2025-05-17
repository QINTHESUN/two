package com.cp.subject.domain.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Comments)表实体类
 * 
 * @author makejava
 * @since 2024-11-08 15:16:11
 */

@Data
public class CommentsBo implements Serializable {

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

