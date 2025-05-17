package com.cp.subject.domain.bo;

import com.cp.subject.common.entity.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 题目信息表(SubjectInfo)表实体类
 * 
 * @author makejava
 * @since 2024-10-22 20:09:53
 */

@Data
public class SubjectInfoBo extends PageInfo implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 题目名称
     */
    private String subjectName;

    /**
     * 题目难度
     */
    private Integer subjectDifficult;

    /**
     * 出题人名
     */
    private String settleName;

    /**
     * 题目类型 1单选 2多选 3判断 4简答
     */
    private Integer subjectType;

    /**
     * 题目分数
     */
    private Integer subjectScore;

    /**
     * 题目解析
     */
    private String subjectParse;


    /**
     * 题目答案
     */
    private String subjectAnswer;


    /**
     * 题目分类id
     */
    private List<Integer> categoryIds;


    /**
     * 标签id
     */
    private List<Integer> labelIds;


    /**
     * 答案选项
     */
    private List<SubjectAnswerBo> optionList;


    /**
     * 标签名字
     */
    private List<String> labelName;


    private Long categoryId;



    private Long labelId;

    /**
     * 关键词
     */
    private String keyWord;


    /**
     * 创建人昵称
     */
    private String createUser;

    /**
     * 创建人头像
     */
    private String createUserAvatar;

    /**
     * 题目数量
     */
    private Integer subjectCount;

    /**
     * 是否被当前用户点赞
     */
    private Boolean liked;

    /**
     * 当前题目点赞的数量
     */
    private Integer likedCount;

    /**
     * 下一题
     */
    private Long nextSubjectId;

    /**
     * 上一题
     */
    private Long lastSubjectId;

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

