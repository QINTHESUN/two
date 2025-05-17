package com.cp.auth.domain.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.auth.domain.bo.AuthRoleBo;
import com.cp.auth.infra.basic.entity.AuthRoleEntity;
import javafx.beans.binding.BooleanBinding;

import java.util.List;

/**
 * (AuthRole)表服务接口
 * 
 * @author makejava
 * @since 2024-10-26 09:02:57
 */
public interface AuthRoleDomainService {

    /**
     * 添加角色
     * @param authRoleBo
     * @return
     */
    Boolean addRole(AuthRoleBo authRoleBo);

    /**
     * 修改角色
     * @param authRoleBo
     * @return
     */
    Boolean updateRole(AuthRoleBo authRoleBo);

    /**\
     * 删除角色
     * @param authRoleBo
     * @return
     */
    Boolean deleteRole(AuthRoleBo authRoleBo);

    List<AuthRoleBo> queryAllRole(int i);
}
