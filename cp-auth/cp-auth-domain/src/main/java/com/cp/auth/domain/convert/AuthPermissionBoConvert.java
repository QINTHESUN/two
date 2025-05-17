package com.cp.auth.domain.convert;

import com.cp.auth.domain.bo.AuthPermissionBo;
import com.cp.auth.domain.bo.AuthRoleBo;
import com.cp.auth.infra.basic.entity.AuthPermissionEntity;
import com.cp.auth.infra.basic.entity.AuthRoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/25 下午2:23
 **/
@Mapper
public interface AuthPermissionBoConvert {

    AuthPermissionBoConvert INSTANCE = Mappers.getMapper(AuthPermissionBoConvert.class);

    AuthPermissionEntity convertBoToEntity(AuthPermissionBo authPermissionBo);

    List<AuthPermissionBo> convertEntityToBoList(List<AuthPermissionEntity> authPermissionEntities);
}
