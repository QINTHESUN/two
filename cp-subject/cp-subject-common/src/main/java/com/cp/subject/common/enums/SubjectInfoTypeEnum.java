package com.cp.subject.common.enums;

import lombok.Getter;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 3/9/2024 下午 9:50
 *
 * 1.单选 2.多选 3.判断 4.简答
 **/
@Getter
public enum SubjectInfoTypeEnum {

    RADIO(1,"单选"),
    MULTIPLE(2,"多选"),
    JUDGE(3,"判断"),
    BRIEF(4,"简答");




    public int code;

    public String desc;

    SubjectInfoTypeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }


    public static SubjectInfoTypeEnum getByCode(int codeVal){
        for (SubjectInfoTypeEnum resultCodeEnum : SubjectInfoTypeEnum.values()){
            if (resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
