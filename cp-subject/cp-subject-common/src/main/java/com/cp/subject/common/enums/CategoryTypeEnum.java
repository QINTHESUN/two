package com.cp.subject.common.enums;

import lombok.Getter;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 3/9/2024 下午 9:50
 *
 * 分类类型枚举
 **/
@Getter
public enum CategoryTypeEnum {

    PRIMARY(1,"岗位大类"),
    SECOND(2,"二级分类");


    public int code;

    public String desc;

    CategoryTypeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }


    public static CategoryTypeEnum getByCode(int codeVal){
        for (CategoryTypeEnum resultCodeEnum : CategoryTypeEnum.values()){
            if (resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
