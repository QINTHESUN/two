package com.cp.subject.infra.basic.entity;

import com.cp.subject.common.entity.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/11/2 下午3:00
 **/
@Data
public class SubjectInfoEs extends PageInfo implements Serializable {

    private Long subjectId;

    private Long docId;

    private String subjectName;

    private String subjectAnswer;

    private String createUser;

    private Date createTime;

    private Integer subjectType;

    private String keyWord;

    private BigDecimal score;




}
