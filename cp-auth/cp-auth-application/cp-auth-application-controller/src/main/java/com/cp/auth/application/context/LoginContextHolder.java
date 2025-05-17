package com.cp.auth.application.context;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 登录上下文对象
 *
 * @Author: q
 * @Description: TODO
 * @DateTime: 30/9/2024 下午 1:51
 **/
public class LoginContextHolder {

    private static final InheritableThreadLocal<Map<String,Object>> THREAD_LOCAL
            = new InheritableThreadLocal<>();

    public static void set(String  key, Object value) {
        Map<String, Object> map = getThreadLocalMap();
        map.put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> threadLocalMap = getThreadLocalMap();
        return threadLocalMap.get(key);
    }

    public static void remove(){
        THREAD_LOCAL.remove();
    }

    public static String getLoginId(){
        return (String) getThreadLocalMap().get("loginId");
    }


    public static Map<String,Object> getThreadLocalMap(){
        Map<String, Object> map = THREAD_LOCAL.get();
         if (Objects.isNull(map)){
             map = new ConcurrentHashMap<>();
             THREAD_LOCAL.set(map);
         }
        return map;
    }

}
