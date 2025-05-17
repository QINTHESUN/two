package com.cp.subject.application.dto;

import lombok.Data;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/22 下午9:01
 **/
@Data
public class SubjectAnswerDto {
    /**
     * 答案选项标识
     */
    private Integer optionType;


    /**
     * 答案
     */
    private String optionContent;

    /**
     * 是否正确
     */
    private Integer isCorrect;

}
