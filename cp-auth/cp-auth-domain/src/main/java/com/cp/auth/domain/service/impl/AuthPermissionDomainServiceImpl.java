package com.cp.auth.domain.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.cp.auth.common.enums.IsDeletedFlagEnum;
import com.cp.auth.domain.bo.AuthPermissionBo;
import com.cp.auth.domain.convert.AuthPermissionBoConvert;
import com.cp.auth.domain.redis.RedisUtil;
import com.cp.auth.domain.service.AuthPermissionDomainService;
import com.cp.auth.infra.basic.entity.AuthPermissionEntity;
import com.cp.auth.infra.basic.service.AuthPermissionService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (AuthPermission)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-26 09:03:19
 */
@Service
public class AuthPermissionDomainServiceImpl  implements AuthPermissionDomainService {

    @Resource
    private AuthPermissionService authPermissionService;


    @Resource
    private RedisUtil redisUtil;

    private String authPermissionPrefix = "auth.permission";


    @Override
    public Boolean addPermission(AuthPermissionBo authPermissionBo) {
        AuthPermissionEntity authPermissionEntity =
                AuthPermissionBoConvert.INSTANCE.convertBoToEntity(authPermissionBo);
        authPermissionEntity.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        boolean result = authPermissionService.addPermission(authPermissionEntity);
        return result;
    }

    @Override
    public Boolean updatePermission(AuthPermissionBo authPermissionBo) {
        AuthPermissionEntity authPermissionEntity = AuthPermissionBoConvert.INSTANCE.convertBoToEntity(authPermissionBo);
        return authPermissionService.updatePermission(authPermissionEntity);

    }

    @Override
    public Boolean deletePermission(AuthPermissionBo authPermissionBo) {
        AuthPermissionEntity authPermissionEntity = AuthPermissionBoConvert.INSTANCE.convertBoToEntity(authPermissionBo);
        return authPermissionService.deletePermission(authPermissionEntity);
    }

    @Override
    public List<String> queryPermission(String userName) {
        String permissionKey = redisUtil.buildKey(authPermissionPrefix, userName);
        String permissionVal = redisUtil.get(permissionKey);
        if (StringUtils.isBlank(permissionVal)){
            return Collections.emptyList();
        }
        List<AuthPermissionEntity> authPermissionEntityList = new Gson().fromJson(permissionVal, new TypeToken<List<AuthPermissionEntity>>() {
        }.getType());
        List<String> authList = authPermissionEntityList.stream().map(AuthPermissionEntity::getPermissionKey).collect(Collectors.toList());
        return authList;
    }

    @Override
    public List<AuthPermissionBo> queryAllPermission() {
        List<AuthPermissionEntity> authPermissionEntityList  =
                authPermissionService.queryAllPermission();
        List<AuthPermissionBo> authPermissionBoList = AuthPermissionBoConvert.INSTANCE.convertEntityToBoList(authPermissionEntityList);
        return authPermissionBoList;
    }
}
