package com.cp.auth.infra.basic.mapper;

import java.util.Date;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.auth.infra.basic.entity.AuthUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息表(AuthUser)表数据库访问层
 * 
 * @author makejava
 * @since 2024-10-25 13:58:50
 */
@Mapper
public interface AuthUserDao extends BaseMapper<AuthUserEntity> {

}
