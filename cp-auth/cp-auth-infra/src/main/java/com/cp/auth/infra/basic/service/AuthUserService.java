package com.cp.auth.infra.basic.service;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.auth.infra.basic.entity.AuthUserEntity;

/**
 * 用户信息表(AuthUser)表服务接口
 * 
 * @author makejava
 * @since 2024-10-25 13:58:49
 */
public interface AuthUserService extends IService<AuthUserEntity> {

    /**
     * 根据账户查看用户数量
     * @param userName
     * @return
     */
    int queryUser(String userName);


    /**
     * 修改用户状态
     * @param authUserEntity
     * @return
     */
    Boolean updateStatus(AuthUserEntity authUserEntity);


    /**
     * 修改用户信息
     * @param authUserEntity
     * @return
     */
    Boolean updateInfo(AuthUserEntity authUserEntity);

    /**
     * 删除用户
     * @param authUserEntity
     * @return
     */
    Boolean deleteUser(AuthUserEntity authUserEntity);

    /**
     * 获取用户信息
     * @param authUserEntity
     * @return
     */
    AuthUserEntity getInfo(AuthUserEntity authUserEntity);

    List<AuthUserEntity> queryAllUser(int i);
}
