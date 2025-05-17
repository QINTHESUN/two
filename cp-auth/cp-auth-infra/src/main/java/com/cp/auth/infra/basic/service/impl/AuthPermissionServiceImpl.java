package com.cp.auth.infra.basic.service.impl;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.auth.common.enums.IsDeletedFlagEnum;
import com.cp.auth.infra.basic.mapper.AuthPermissionDao;
import com.cp.auth.infra.basic.entity.AuthPermissionEntity;
import com.cp.auth.infra.basic.service.AuthPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (AuthPermission)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-26 09:03:19
 */
@Service("authPermissionService")
public class AuthPermissionServiceImpl extends ServiceImpl<AuthPermissionDao, AuthPermissionEntity> implements AuthPermissionService {

    @Resource
    private AuthPermissionDao authPermissionDao;


    @Override
    public boolean addPermission(AuthPermissionEntity authPermissionEntity) {
        int insert = authPermissionDao.insert(authPermissionEntity);
        return insert > 0;
    }

    @Override
    public Boolean updatePermission(AuthPermissionEntity authPermissionEntity) {
        LambdaUpdateWrapper<AuthPermissionEntity> authPermissionEntityLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        authPermissionEntityLambdaUpdateWrapper.eq(AuthPermissionEntity::getId, authPermissionEntity.getId())
                .eq(AuthPermissionEntity::getIsDeleted, IsDeletedFlagEnum.UN_DELETED.getCode());
        return authPermissionDao.update(authPermissionEntity,authPermissionEntityLambdaUpdateWrapper)>0;
    }

    @Override
    public Boolean deletePermission(AuthPermissionEntity authPermissionEntity) {
        LambdaUpdateWrapper<AuthPermissionEntity> eq = new LambdaUpdateWrapper<AuthPermissionEntity>().eq(AuthPermissionEntity::getId, authPermissionEntity.getId());
        eq.set(AuthPermissionEntity::getIsDeleted, IsDeletedFlagEnum.DELETED.getCode());
        return authPermissionDao.update(authPermissionEntity,eq)>0;
    }

    @Override
    public List<AuthPermissionEntity> queryBath(List<Long> permissionIdList) {
          return authPermissionDao.selectBatchIds(permissionIdList);
    }

    @Override
    public List<AuthPermissionEntity> queryAllPermission() {
        LambdaQueryWrapper<AuthPermissionEntity> authPermissionEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        authPermissionEntityLambdaQueryWrapper.eq(AuthPermissionEntity::getIsDeleted, IsDeletedFlagEnum.UN_DELETED.getCode());
        return authPermissionDao.selectList(authPermissionEntityLambdaQueryWrapper);
    }


}
