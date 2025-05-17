package com.cp.auth.infra.basic.mapper;

import java.util.Date;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.auth.infra.basic.entity.AuthPermissionEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (AuthPermission)表数据库访问层
 * 
 * @author makejava
 * @since 2024-10-26 09:03:19
 */
@Mapper
public interface AuthPermissionDao extends BaseMapper<AuthPermissionEntity> {

}
