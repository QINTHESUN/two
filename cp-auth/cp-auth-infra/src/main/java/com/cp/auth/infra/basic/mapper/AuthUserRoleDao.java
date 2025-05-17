package com.cp.auth.infra.basic.mapper;

import java.util.Date;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.auth.infra.basic.entity.AuthUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户角色表(AuthUserRole)表数据库访问层
 * 
 * @author makejava
 * @since 2024-10-30 13:27:17
 */
@Mapper
public interface AuthUserRoleDao extends BaseMapper<AuthUserRoleEntity> {

}
