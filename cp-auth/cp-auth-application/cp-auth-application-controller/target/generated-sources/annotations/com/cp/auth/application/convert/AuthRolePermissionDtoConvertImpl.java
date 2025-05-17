package com.cp.auth.application.convert;

import com.cp.auth.application.dto.AuthRolePermissionDto;
import com.cp.auth.domain.bo.AuthRolePermissionBo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:16:42+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class AuthRolePermissionDtoConvertImpl implements AuthRolePermissionDtoConvert {

    @Override
    public AuthRolePermissionBo convertDtoToBo(AuthRolePermissionDto dto) {
        if ( dto == null ) {
            return null;
        }

        AuthRolePermissionBo authRolePermissionBo = new AuthRolePermissionBo();

        authRolePermissionBo.setId( dto.getId() );
        authRolePermissionBo.setRoleId( dto.getRoleId() );
        authRolePermissionBo.setPermissionId( dto.getPermissionId() );
        List<Long> list = dto.getPermissionIdList();
        if ( list != null ) {
            authRolePermissionBo.setPermissionIdList( new ArrayList<Long>( list ) );
        }
        authRolePermissionBo.setCreatedBy( dto.getCreatedBy() );
        authRolePermissionBo.setCreatedTime( dto.getCreatedTime() );
        authRolePermissionBo.setUpdateBy( dto.getUpdateBy() );
        authRolePermissionBo.setUpdateTime( dto.getUpdateTime() );
        authRolePermissionBo.setIsDeleted( dto.getIsDeleted() );

        return authRolePermissionBo;
    }
}
