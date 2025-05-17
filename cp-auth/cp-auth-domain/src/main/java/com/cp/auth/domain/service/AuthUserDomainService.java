package com.cp.auth.domain.service;
import cn.dev33.satoken.stp.SaTokenInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.auth.domain.bo.AuthUserBo;
import com.cp.auth.infra.basic.entity.AuthUserEntity;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * 用户信息表(AuthUser)表服务接口
 * 
 * @author makejava
 * @since 2024-10-25 13:58:49
 */
public interface AuthUserDomainService {

    /**
     * 注册用户
     * @param authUserBo
     * @return
     */
    Boolean register(AuthUserBo authUserBo);


    /**
     * 修改用户的状态
     * @param authUserBo
     * @return
     */
    Boolean updateStatus(AuthUserBo authUserBo);

    /**
     * 修改用户信息
     * @param authUserBo
     * @return
     */
    Boolean updateInfo(AuthUserBo authUserBo);


    /**
     * 删除用户信息
     * @param authUserBo
     * @return
     */
    Boolean deleteUser(AuthUserBo authUserBo);

    /**
     * 获取用户信息
     * @param authUserBo
     * @return
     */
    AuthUserBo getInfo(AuthUserBo authUserBo);

    /**
     * 登录
     * @param validCode
     * @return
     */
    SaTokenInfo doLogin(String validCode);

    List<AuthUserBo> queryAllUser(int i);
}
