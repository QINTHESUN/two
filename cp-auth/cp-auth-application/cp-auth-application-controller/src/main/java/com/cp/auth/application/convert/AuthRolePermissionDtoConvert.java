package com.cp.auth.application.convert;

import com.cp.auth.application.dto.AuthPermissionDto;
import com.cp.auth.application.dto.AuthRolePermissionDto;
import com.cp.auth.domain.bo.AuthPermissionBo;
import com.cp.auth.domain.bo.AuthRolePermissionBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/25 下午2:23
 **/
@Mapper
public interface AuthRolePermissionDtoConvert {

    AuthRolePermissionDtoConvert INSTANCE = Mappers.getMapper(AuthRolePermissionDtoConvert.class);

    AuthRolePermissionBo convertDtoToBo(AuthRolePermissionDto dto);

}
