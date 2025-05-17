package com.cp.auth.domain.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.auth.domain.bo.AuthRolePermissionBo;
import com.cp.auth.infra.basic.entity.AuthRolePermissionEntity;

/**
 * 角色权限关联表(AuthRolePermission)表服务接口
 * 
 * @author makejava
 * @since 2024-10-28 10:28:59
 */
public interface AuthRolePermissionDomainService {

    /**
     *
     * @param authRolePermissionBo
     * @return
     */
    Boolean addRolePermission(AuthRolePermissionBo authRolePermissionBo);
}
