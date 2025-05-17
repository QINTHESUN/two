package com.cp.gateway.auth;
import cn.dev33.satoken.stp.StpInterface;
import com.alibaba.cloud.commons.lang.StringUtils;
import com.cp.gateway.entity.AuthPermissionEntity;
import com.cp.gateway.entity.AuthRoleEntity;
import com.cp.gateway.redis.RedisUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义权限验证接口扩展
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private RedisUtil redisUtil;

    private String authPermissionPrefis = "auth.permission";

    private String authRolePrefix = "auth.role";

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的权限列表
        //1.直接跟数据库交互(容易崩)
        //2.放在redis缓存(推荐)
        //3.redis缓存没有的话，去调用我们的微服务去获取
        return getAuth(loginId.toString(),authRolePrefix);
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return getAuth(loginId.toString(),authRolePrefix);
    }

    private List<String> getAuth(String loginId,String prefix){
        String authKey = redisUtil.buildKey(authRolePrefix, loginId.toString());
        String authValue = redisUtil.get(authKey);
        if (StringUtils.isBlank(authValue)){
            return Collections.emptyList();
        }
        List<String> authList = new LinkedList<>();
        if (authRolePrefix.equals(prefix)){
            List<AuthRoleEntity> roleList = new Gson().fromJson(authValue, new TypeToken<List<AuthRoleEntity>>(){
            }.getType());
            authList = roleList.stream().map(AuthRoleEntity::getRoleKey).collect(Collectors.toList());
        } else if (authPermissionPrefis.equals(prefix)) {
            List<AuthPermissionEntity> roleList = new Gson().fromJson(authValue, new TypeToken<List<AuthPermissionEntity>>(){
            }.getType());
            authList = roleList.stream().map(AuthPermissionEntity::getPermissionKey).collect(Collectors.toList());
        }
        return authList;
    }

}


