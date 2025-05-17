package com.cp.subject.common.util;

import com.cp.subject.common.context.LoginContextHolder;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/11/1 上午8:33
 **/
public class LoginUtil {

    public static String getLoginId() {
        return LoginContextHolder.getLoginId();
    }


}
