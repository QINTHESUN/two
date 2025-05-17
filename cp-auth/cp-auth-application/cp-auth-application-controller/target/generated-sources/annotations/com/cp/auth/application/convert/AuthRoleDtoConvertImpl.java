package com.cp.auth.application.convert;

import com.cp.auth.application.dto.AuthRoleDto;
import com.cp.auth.domain.bo.AuthRoleBo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:16:42+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class AuthRoleDtoConvertImpl implements AuthRoleDtoConvert {

    @Override
    public AuthRoleBo convertDtoToBo(AuthRoleDto dto) {
        if ( dto == null ) {
            return null;
        }

        AuthRoleBo authRoleBo = new AuthRoleBo();

        authRoleBo.setId( dto.getId() );
        authRoleBo.setRoleName( dto.getRoleName() );
        authRoleBo.setRoleKey( dto.getRoleKey() );
        authRoleBo.setCreatedBy( dto.getCreatedBy() );
        authRoleBo.setCreatedTime( dto.getCreatedTime() );
        authRoleBo.setUpdateBy( dto.getUpdateBy() );
        authRoleBo.setUpdateTime( dto.getUpdateTime() );
        authRoleBo.setIsDeleted( dto.getIsDeleted() );

        return authRoleBo;
    }

    @Override
    public List<AuthRoleDto> convertBoToDtoList(List<AuthRoleBo> boList) {
        if ( boList == null ) {
            return null;
        }

        List<AuthRoleDto> list = new ArrayList<AuthRoleDto>( boList.size() );
        for ( AuthRoleBo authRoleBo : boList ) {
            list.add( authRoleBoToAuthRoleDto( authRoleBo ) );
        }

        return list;
    }

    protected AuthRoleDto authRoleBoToAuthRoleDto(AuthRoleBo authRoleBo) {
        if ( authRoleBo == null ) {
            return null;
        }

        AuthRoleDto authRoleDto = new AuthRoleDto();

        authRoleDto.setId( authRoleBo.getId() );
        authRoleDto.setRoleName( authRoleBo.getRoleName() );
        authRoleDto.setRoleKey( authRoleBo.getRoleKey() );
        authRoleDto.setCreatedBy( authRoleBo.getCreatedBy() );
        authRoleDto.setCreatedTime( authRoleBo.getCreatedTime() );
        authRoleDto.setUpdateBy( authRoleBo.getUpdateBy() );
        authRoleDto.setUpdateTime( authRoleBo.getUpdateTime() );
        authRoleDto.setIsDeleted( authRoleBo.getIsDeleted() );

        return authRoleDto;
    }
}
