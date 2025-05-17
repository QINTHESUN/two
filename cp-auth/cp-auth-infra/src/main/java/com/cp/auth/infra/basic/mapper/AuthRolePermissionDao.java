package com.cp.auth.infra.basic.mapper;

import java.util.Date;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.auth.infra.basic.entity.AuthRolePermissionEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色权限关联表(AuthRolePermission)表数据库访问层
 * 
 * @author makejava
 * @since 2024-10-28 10:28:59
 */
@Mapper
public interface AuthRolePermissionDao extends BaseMapper<AuthRolePermissionEntity> {

}
