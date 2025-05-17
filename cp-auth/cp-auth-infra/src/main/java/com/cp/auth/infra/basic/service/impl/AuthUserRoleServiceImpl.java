package com.cp.auth.infra.basic.service.impl;
import java.util.Date;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.auth.infra.basic.mapper.AuthUserRoleDao;
import com.cp.auth.infra.basic.entity.AuthUserRoleEntity;
import com.cp.auth.infra.basic.service.AuthUserRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户角色表(AuthUserRole)表服务实现类
 * 
 * @author makejava
 * @since 2024-10-30 13:27:17
 */
@Service("authUserRoleService")
public class AuthUserRoleServiceImpl extends ServiceImpl<AuthUserRoleDao, AuthUserRoleEntity> implements AuthUserRoleService {
}
