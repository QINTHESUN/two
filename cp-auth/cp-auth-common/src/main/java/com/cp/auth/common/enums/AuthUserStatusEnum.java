package com.cp.auth.common.enums;

import lombok.Getter;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 3/9/2024 下午 9:50
 * <p>
 * 用户状态，枚举
 **/
@Getter
public enum AuthUserStatusEnum {

    OPEN(1, "启用"),
    CLOSE(0, "禁用");


    public int code;

    public String desc;

    AuthUserStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public static AuthUserStatusEnum getByCode(int codeVal) {
        for (AuthUserStatusEnum resultCodeEnum : AuthUserStatusEnum.values()) {
            if (resultCodeEnum.code == codeVal) {
                return resultCodeEnum;
            }
        }
        return null;
    }

}
