package com.cp.auth.application.convert;

import com.cp.api.entity.AuthUserDto;
import com.cp.auth.domain.bo.AuthUserBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/25 下午2:23
 **/
@Mapper
public interface AuthUserDtoConvert {

    AuthUserDtoConvert INSTANCE = Mappers.getMapper(AuthUserDtoConvert.class);

    AuthUserBo convertDtoToBo(AuthUserDto dto);

    AuthUserDto convertBoToDto(AuthUserBo bo);

    List<AuthUserDto> convertBoListToDtoList(List<AuthUserBo> boList);
}
