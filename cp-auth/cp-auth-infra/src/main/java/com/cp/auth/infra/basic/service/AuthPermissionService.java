package com.cp.auth.infra.basic.service;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.auth.infra.basic.entity.AuthPermissionEntity;

/**
 * (AuthPermission)表服务接口
 * 
 * @author makejava
 * @since 2024-10-26 09:03:19
 */
public interface AuthPermissionService extends IService<AuthPermissionEntity> {

    /**
     * 添加权限
     * @param authPermissionEntity
     * @return
     */
    boolean addPermission(AuthPermissionEntity authPermissionEntity);


    /**
     * 修改权限
     * @param authPermissionEntity
     * @return
     */
    Boolean updatePermission(AuthPermissionEntity authPermissionEntity);

    /**
     * 删除权限
     * @param authPermissionEntity
     * @return
     */
    Boolean deletePermission(AuthPermissionEntity authPermissionEntity);

    /**
     * 根据idList查询
     * @param permissionIdList
     * @return
     */
    List<AuthPermissionEntity> queryBath(List<Long> permissionIdList);

    List<AuthPermissionEntity> queryAllPermission();
}
