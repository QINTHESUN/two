package com.cp.auth.infra.basic.service.impl;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.auth.infra.basic.mapper.AuthRolePermissionDao;
import com.cp.auth.infra.basic.entity.AuthRolePermissionEntity;
import com.cp.auth.infra.basic.service.AuthRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色权限关联表(AuthRolePermission)表服务实现类
 *
 * @author makejava
 * @since 2024-10-28 10:28:59
 */
@Service("authRolePermissionService")
public class AuthRolePermissionServiceImpl extends ServiceImpl<AuthRolePermissionDao, AuthRolePermissionEntity> implements AuthRolePermissionService {

    @Resource
    private AuthRolePermissionDao authRolePermissionDao;


    @Override
    public List<AuthRolePermissionEntity> queryRolePermission(AuthRolePermissionEntity permission) {
        LambdaQueryWrapper<AuthRolePermissionEntity> authRolePermissionEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        authRolePermissionEntityLambdaQueryWrapper.eq(AuthRolePermissionEntity::getRoleId, permission.getRoleId());
        return authRolePermissionDao.selectList(authRolePermissionEntityLambdaQueryWrapper);
    }
}
