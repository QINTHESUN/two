package com.cp.gateway.enums;

import lombok.Getter;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 3/9/2024 下午 9:50
 **/
@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    FAIL(500,"失败");



    public int code;

    public String desc;

    ResultCodeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }


    public static ResultCodeEnum getByCode(int codeVal){
        for (ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()){
            if (resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
