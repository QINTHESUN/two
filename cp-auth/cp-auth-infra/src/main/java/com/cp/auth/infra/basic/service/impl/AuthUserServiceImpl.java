package com.cp.auth.infra.basic.service.impl;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.auth.common.enums.AuthUserStatusEnum;
import com.cp.auth.common.enums.IsDeletedFlagEnum;
import com.cp.auth.infra.basic.mapper.AuthUserDao;
import com.cp.auth.infra.basic.entity.AuthUserEntity;
import com.cp.auth.infra.basic.service.AuthUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户信息表(AuthUser)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-25 13:58:49
 */
@Service("authUserService")
public class AuthUserServiceImpl extends ServiceImpl<AuthUserDao, AuthUserEntity> implements AuthUserService {

    @Resource
    private AuthUserDao authUserDao;


    @Override
    public int queryUser(String userName) {
        LambdaQueryWrapper<AuthUserEntity> authUserEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        authUserEntityLambdaQueryWrapper.eq(AuthUserEntity::getUserName,userName);
        return authUserDao.selectCount(authUserEntityLambdaQueryWrapper);
    }

    @Override
    public Boolean updateStatus(AuthUserEntity authUserEntity) {
        LambdaUpdateWrapper<AuthUserEntity> authUserEntityLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        authUserEntityLambdaUpdateWrapper.eq(AuthUserEntity::getId,authUserEntity.getId())
                .eq(AuthUserEntity::getIsDeleted, IsDeletedFlagEnum.UN_DELETED.getCode());
        int update = authUserDao.update(authUserEntity, authUserEntityLambdaUpdateWrapper);
        return update > 0;
    }

    @Override
    public Boolean updateInfo(AuthUserEntity authUserEntity) {
        LambdaUpdateWrapper<AuthUserEntity> authUserEntityLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        authUserEntityLambdaUpdateWrapper.eq(AuthUserEntity::getId,authUserEntity.getId())
                .eq(AuthUserEntity::getIsDeleted, IsDeletedFlagEnum.UN_DELETED.getCode());
        int update = authUserDao.update(authUserEntity, authUserEntityLambdaUpdateWrapper);
        return update > 0;
    }

    @Override
    public Boolean deleteUser(AuthUserEntity authUserEntity) {
        LambdaUpdateWrapper<AuthUserEntity> authUserEntityLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        authUserEntityLambdaUpdateWrapper.eq(AuthUserEntity::getId,authUserEntity.getId())
                .set(AuthUserEntity::getIsDeleted, IsDeletedFlagEnum.DELETED.getCode());
        return authUserDao.update(authUserEntity, authUserEntityLambdaUpdateWrapper) > 0;
    }

    @Override
    public AuthUserEntity getInfo(AuthUserEntity authUserEntity) {
        LambdaQueryWrapper<AuthUserEntity> authUserEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        authUserEntityLambdaQueryWrapper.eq(AuthUserEntity::getUserName,authUserEntity.getUserName())
                .eq(AuthUserEntity::getIsDeleted, IsDeletedFlagEnum.UN_DELETED.getCode());
        return authUserDao.selectOne(authUserEntityLambdaQueryWrapper);

    }

    @Override
    public List<AuthUserEntity> queryAllUser(int i) {
        LambdaQueryWrapper<AuthUserEntity> authUserEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        authUserEntityLambdaQueryWrapper.eq(AuthUserEntity::getIsDeleted, 0);
        return authUserDao.selectList(authUserEntityLambdaQueryWrapper);
    }

}
