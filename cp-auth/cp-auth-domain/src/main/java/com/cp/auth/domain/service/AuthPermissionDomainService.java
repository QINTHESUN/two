package com.cp.auth.domain.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.auth.domain.bo.AuthPermissionBo;
import com.cp.auth.infra.basic.entity.AuthPermissionEntity;

import java.util.List;

/**
 * (AuthPermission)表服务接口
 * 
 * @author makejava
 * @since 2024-10-26 09:03:19
 */
public interface AuthPermissionDomainService  {

    /**
     * 新增权限
     * @param authPermissionBo
     * @return
     */
    Boolean addPermission(AuthPermissionBo authPermissionBo);


    /**
     * 修改权限
     * @param authPermissionBo
     * @return
     */
    Boolean updatePermission(AuthPermissionBo authPermissionBo);

    /**
     * 删除权限
     * @param authPermissionBo
     * @return
     */
    Boolean deletePermission(AuthPermissionBo authPermissionBo);

    /**|
     * 获取用户信息
     *
     * @param userName
     * @return
     */
    List<String> queryPermission(String userName);


    List<AuthPermissionBo> queryAllPermission();

}
