package com.cp.auth.infra.basic.service;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.auth.infra.basic.entity.AuthRolePermissionEntity;

/**
 * 角色权限关联表(AuthRolePermission)表服务接口
 * 
 * @author makejava
 * @since 2024-10-28 10:28:59
 */
public interface AuthRolePermissionService extends IService<AuthRolePermissionEntity> {

    /**
     * 根据roleId查询
     * @param permission
     * @return
     */
    List<AuthRolePermissionEntity> queryRolePermission(AuthRolePermissionEntity permission);
}
