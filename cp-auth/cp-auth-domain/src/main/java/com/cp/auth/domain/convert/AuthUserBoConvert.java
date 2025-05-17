package com.cp.auth.domain.convert;

import com.cp.auth.domain.bo.AuthUserBo;
import com.cp.auth.infra.basic.entity.AuthUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/25 下午2:23
 **/
@Mapper
public interface AuthUserBoConvert {

    AuthUserBoConvert INSTANCE = Mappers.getMapper(AuthUserBoConvert.class);

    AuthUserEntity convertBoToEntity(AuthUserBo authUserBo);

    AuthUserBo convertEntityToBo(AuthUserEntity authUserEntity);

    List<AuthUserBo> convertEntityListToBoList(List<AuthUserEntity> authUserEntities);
}
