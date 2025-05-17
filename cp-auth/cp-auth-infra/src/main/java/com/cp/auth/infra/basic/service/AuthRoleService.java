package com.cp.auth.infra.basic.service;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.auth.infra.basic.entity.AuthRoleEntity;

/**
 * (AuthRole)表服务接口
 * 
 * @author makejava
 * @since 2024-10-26 09:02:57
 */
public interface AuthRoleService extends IService<AuthRoleEntity> {

    /**
     * 修改角色
      * @param authRoleEntity
     * @return
     */
    Boolean updateRole(AuthRoleEntity authRoleEntity);

    /**
     * 删除角色
     * @param authRoleEntity
     * @return
     */
    Boolean deleteRole(AuthRoleEntity authRoleEntity);

    /**
     * 根据角色关键字查询
     * @param authRoleEntity
     * @return
     */
    AuthRoleEntity queryRole(AuthRoleEntity authRoleEntity);

    List<AuthRoleEntity> queryAllRole(int i);
}
