package com.cp.auth.domain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.auth.common.enums.IsDeletedFlagEnum;
import com.cp.auth.domain.bo.AuthRolePermissionBo;
import com.cp.auth.domain.service.AuthRolePermissionDomainService;
import com.cp.auth.infra.basic.entity.AuthRolePermissionEntity;
import com.cp.auth.infra.basic.mapper.AuthRolePermissionDao;
import com.cp.auth.infra.basic.service.AuthRolePermissionService;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 角色权限关联表(AuthRolePermission)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-28 10:28:59
 */
@Service
public class AuthRolePermissionDomainServiceImpl  implements AuthRolePermissionDomainService {

    @Resource
    private AuthRolePermissionService authRolePermissionService;


    @Override
    public Boolean addRolePermission(AuthRolePermissionBo authRolePermissionBo) {
        List<AuthRolePermissionEntity> authRolePermissionEntityList = new LinkedList<>();
        authRolePermissionBo.getPermissionIdList().forEach(permissionId -> {
            AuthRolePermissionEntity authRolePermissionEntity = new AuthRolePermissionEntity();
            authRolePermissionEntity.setRoleId(authRolePermissionBo.getRoleId());
            authRolePermissionEntity.setPermissionId(permissionId);
            authRolePermissionEntity.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            authRolePermissionEntityList.add(authRolePermissionEntity);
        });
        boolean result = authRolePermissionService.saveBatch(authRolePermissionEntityList);
        return result;
    }
}
