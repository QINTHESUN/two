package com.cp.auth.application.convert;

import com.cp.auth.application.dto.AuthPermissionDto;
import com.cp.auth.application.dto.AuthRoleDto;
import com.cp.auth.domain.bo.AuthPermissionBo;
import com.cp.auth.domain.bo.AuthRoleBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/25 下午2:23
 **/
@Mapper
public interface AuthPermissionDtoConvert {

    AuthPermissionDtoConvert INSTANCE = Mappers.getMapper(AuthPermissionDtoConvert.class);

    AuthPermissionBo convertDtoToBo(AuthPermissionDto dto);


    List<AuthPermissionDto>  convertBoToDtoList(List<AuthPermissionBo> boList);

}
