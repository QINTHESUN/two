package com.cp.auth.domain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.auth.common.enums.IsDeletedFlagEnum;
import com.cp.auth.domain.bo.AuthRoleBo;
import com.cp.auth.domain.convert.AuthRoleBoConvert;
import com.cp.auth.domain.convert.AuthUserBoConvert;
import com.cp.auth.domain.service.AuthRoleDomainService;
import com.cp.auth.infra.basic.entity.AuthRoleEntity;
import com.cp.auth.infra.basic.mapper.AuthRoleDao;
import com.cp.auth.infra.basic.service.AuthRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * (AuthRole)表服务实现类
 *
 * @author makejava
 * @since 2024-10-26 09:02:57
 */
@Service
public class AuthRoleDomainServiceImpl implements AuthRoleDomainService {

    @Resource
    private AuthRoleService authRoleService;


    @Override
    public Boolean addRole(AuthRoleBo authRoleBo) {
        AuthRoleEntity authRoleEntity = AuthRoleBoConvert.INSTANCE.convertBoToEntity(authRoleBo);
        authRoleEntity.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        return authRoleService.save(authRoleEntity);
    }

    @Override
    public Boolean updateRole(AuthRoleBo authRoleBo) {
        AuthRoleEntity authRoleEntity = AuthRoleBoConvert.INSTANCE.convertBoToEntity(authRoleBo);
        return authRoleService.updateRole(authRoleEntity);
    }

    @Override
    public Boolean deleteRole(AuthRoleBo authRoleBo) {
        AuthRoleEntity authRoleEntity = AuthRoleBoConvert.INSTANCE.convertBoToEntity(authRoleBo);
        return authRoleService.deleteRole(authRoleEntity);
    }

    @Override
    public List<AuthRoleBo> queryAllRole(int i) {
        List<AuthRoleEntity> authRoleEntityList
                = authRoleService.queryAllRole(0);
        List<AuthRoleBo> authRoleBoList = AuthRoleBoConvert.INSTANCE.convertEntityToBoList(authRoleEntityList);
        return authRoleBoList;
    }
}
