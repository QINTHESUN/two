package com.cp.auth.infra.basic.service.impl;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.auth.common.entity.Result;
import com.cp.auth.common.enums.IsDeletedFlagEnum;
import com.cp.auth.infra.basic.mapper.AuthRoleDao;
import com.cp.auth.infra.basic.entity.AuthRoleEntity;
import com.cp.auth.infra.basic.service.AuthRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (AuthRole)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-26 09:02:57
 */
@Service("authRoleService")
public class AuthRoleServiceImpl extends ServiceImpl<AuthRoleDao, AuthRoleEntity> implements AuthRoleService {

    @Resource
    private AuthRoleDao authRoleDao;


    @Override
    public Boolean updateRole(AuthRoleEntity authRoleEntity) {
        LambdaUpdateWrapper<AuthRoleEntity> authRoleEntityLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        authRoleEntityLambdaUpdateWrapper.eq(AuthRoleEntity::getId, authRoleEntity.getId())
                .eq(AuthRoleEntity::getIsDeleted, IsDeletedFlagEnum.UN_DELETED.getCode());
        return authRoleDao.update(authRoleEntity, authRoleEntityLambdaUpdateWrapper) > 0;
    }

    @Override
    public Boolean deleteRole(AuthRoleEntity authRoleEntity) {
        LambdaUpdateWrapper<AuthRoleEntity> authRoleEntityLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        authRoleEntityLambdaUpdateWrapper.eq(AuthRoleEntity::getId, authRoleEntity.getId())
                .set(AuthRoleEntity::getIsDeleted, IsDeletedFlagEnum.DELETED.getCode());
        return authRoleDao.update(authRoleEntity,authRoleEntityLambdaUpdateWrapper) > 0;
    }

    @Override
    public AuthRoleEntity queryRole(AuthRoleEntity authRoleEntity) {
        LambdaQueryWrapper<AuthRoleEntity> authRoleEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        authRoleEntityLambdaQueryWrapper.eq(AuthRoleEntity::getRoleKey,authRoleEntity.getRoleKey());
        return authRoleDao.selectOne(authRoleEntityLambdaQueryWrapper);
    }

    @Override
    public List<AuthRoleEntity> queryAllRole(int i) {
        LambdaQueryWrapper<AuthRoleEntity> authRoleEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        authRoleEntityLambdaQueryWrapper.eq(AuthRoleEntity::getIsDeleted, IsDeletedFlagEnum.UN_DELETED.getCode());
        return authRoleDao.selectList(authRoleEntityLambdaQueryWrapper);
    }
}
