package com.cp.subject.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (Comments)表实体类
 * 
 * @author makejava
 * @since 2024-11-08 15:16:11
 */

@Data
public class CommentsDto implements Serializable {

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


    private List<CommentsDto> replies;

}

