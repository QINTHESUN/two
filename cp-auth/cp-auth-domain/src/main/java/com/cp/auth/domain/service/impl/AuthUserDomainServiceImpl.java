package com.cp.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.auth.common.enums.AuthUserStatusEnum;
import com.cp.auth.common.enums.IsDeletedFlagEnum;
import com.cp.auth.domain.bo.AuthUserBo;
import com.cp.auth.domain.constants.AuthConstant;
import com.cp.auth.domain.convert.AuthUserBoConvert;
import com.cp.auth.domain.redis.RedisUtil;
import com.cp.auth.domain.service.AuthUserDomainService;
import com.cp.auth.infra.basic.entity.*;
import com.cp.auth.infra.basic.mapper.AuthUserDao;
import com.cp.auth.infra.basic.service.AuthRoleService;
import com.cp.auth.infra.basic.service.AuthUserRoleService;
import com.cp.auth.infra.basic.service.AuthUserService;
import com.cp.auth.infra.basic.service.impl.AuthPermissionServiceImpl;
import com.cp.auth.infra.basic.service.impl.AuthRolePermissionServiceImpl;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户信息表(AuthUser)表服务实现类
 *
 * @author makejava
 * @since 2024-10-25 13:58:49
 */
@Service
public class  AuthUserDomainServiceImpl implements AuthUserDomainService {

    @Resource
    private AuthUserService authUserService;

    @Resource
    private AuthRoleService authRoleService;

    @Resource
    private AuthUserRoleService authUserRoleService;

    @Resource
    private RedisUtil redisUtil;

    private String authPermissionPrefix = "auth.permission";

    private String authRolePrefix = "auth.role";

    private static final String LOGIN_PREFIX = "loginCode";

    private String salt = "123123";


    @Autowired
    private AuthRolePermissionServiceImpl authRolePermissionService;
    @Autowired
    private AuthPermissionServiceImpl authPermissionService;


    @Override
    @SneakyThrows
    @Transactional(rollbackFor = Exception.class)
    public Boolean register(AuthUserBo authUserBo) {
        int count = authUserService.queryUser(authUserBo.getUserName());
        if (count > 0) {
            return true;
        }
        AuthUserEntity authUserEntity = AuthUserBoConvert.INSTANCE.convertBoToEntity(authUserBo);
        if (StringUtils.isBlank(authUserEntity.getPassword())) {
            authUserEntity.setPassword(SaSecureUtil.md5BySalt(authUserEntity.getPassword(), salt));
        }
        authUserEntity.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        authUserEntity.setStatus(AuthUserStatusEnum.OPEN.getCode());
        if (StringUtils.isBlank(authUserEntity.getNickName())){
            authUserEntity.setNickName(String.valueOf(Math.random()*2000));
        }
        boolean result = authUserService.save(authUserEntity);

        AuthRoleEntity authRoleEntity = new AuthRoleEntity();
        authRoleEntity.setRoleKey(AuthConstant.NORMAL_USER);
        AuthRoleEntity role = authRoleService.queryRole(authRoleEntity);
        Long roleId = role.getId();
        Long userId = authUserEntity.getId();
        AuthUserRoleEntity authUserRoleEntity = new AuthUserRoleEntity();
        authUserRoleEntity.setRoleId(roleId);
        authUserRoleEntity.setUserId(userId);
        authUserRoleEntity.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        authUserRoleService.save(authUserRoleEntity);

        String roleKey = redisUtil.buildKey(authRolePrefix, authUserEntity.getUserName());
        List<AuthRoleEntity> authRoleEntityList = new LinkedList<>();
        authRoleEntityList.add(authRoleEntity);
        redisUtil.set(roleKey,new Gson().toJson(authRoleEntityList));

        AuthRolePermissionEntity authRolePermissionEntity = new AuthRolePermissionEntity();
        authRolePermissionEntity.setRoleId(roleId);
        List<AuthRolePermissionEntity> authRolePermissionList =
                authRolePermissionService.queryRolePermission(authRolePermissionEntity);

        List<Long> permissionIdList =
                authRolePermissionList.stream().map(AuthRolePermissionEntity::getPermissionId).collect(Collectors.toList());
        //查询权限
        List<AuthPermissionEntity> authPermissionEntityList =
                authPermissionService.queryBath(permissionIdList);
        String permissionKey = redisUtil.buildKey(authPermissionPrefix, authUserEntity.getUserName());
        redisUtil.set(permissionKey,new Gson().toJson(authPermissionEntityList));


        return result;
    }

    @Override
    public Boolean updateStatus(AuthUserBo authUserBo) {
        AuthUserEntity authUserEntity = AuthUserBoConvert.INSTANCE.convertBoToEntity(authUserBo);
        return authUserService.updateStatus(authUserEntity);
    }

    @Override
    public Boolean updateInfo(AuthUserBo authUserBo) {
        AuthUserEntity authUserEntity = AuthUserBoConvert.INSTANCE.convertBoToEntity(authUserBo);
        return authUserService.updateInfo(authUserEntity);
    }

    @Override
    public Boolean deleteUser(AuthUserBo authUserBo) {
        AuthUserEntity authUserEntity = AuthUserBoConvert.INSTANCE.convertBoToEntity(authUserBo);
        return authUserService.deleteUser(authUserEntity);
    }

    @Override
    public AuthUserBo getInfo(AuthUserBo authUserBo) {
        AuthUserEntity authUserEntity = AuthUserBoConvert.INSTANCE.convertBoToEntity(authUserBo);
        AuthUserEntity authUser = authUserService.getInfo(authUserEntity);
        AuthUserBo boResult = AuthUserBoConvert.INSTANCE.convertEntityToBo(authUser);
        return boResult;
    }

    @Override
    public SaTokenInfo doLogin(String validCode) {
        String loginKey = redisUtil.buildKey(LOGIN_PREFIX, validCode);
        String openId = redisUtil.get(loginKey);
        if (StringUtils.isBlank(openId)){
            return null;
        }
        AuthUserBo authUserBo = new AuthUserBo();
        authUserBo.setUserName(openId);
        authUserBo.setNickName(openId);
        this.register(authUserBo);
        StpUtil.login(openId);
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return tokenInfo;
    }

    @Override
    public List<AuthUserBo> queryAllUser(int i) {
        List<AuthUserEntity> authUserEntityList =
                authUserService.queryAllUser(0);
        List<AuthUserBo> authUserBoList = AuthUserBoConvert.INSTANCE.convertEntityListToBoList(authUserEntityList);
        return authUserBoList;
    }
}
