package com.cp.auth.infra.basic.mapper;

import java.util.Date;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.auth.infra.basic.entity.AuthRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (AuthRole)表数据库访问层
 * 
 * @author makejava
 * @since 2024-10-26 09:02:57
 */
@Mapper
public interface AuthRoleDao extends BaseMapper<AuthRoleEntity> {

}
