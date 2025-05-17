package com.cp.auth.domain.convert;

import com.cp.auth.domain.bo.AuthRoleBo;
import com.cp.auth.infra.basic.entity.AuthRoleEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:16:38+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class AuthRoleBoConvertImpl implements AuthRoleBoConvert {

    @Override
    public AuthRoleEntity convertBoToEntity(AuthRoleBo authRoleBo) {
        if ( authRoleBo == null ) {
            return null;
        }

        AuthRoleEntity authRoleEntity = new AuthRoleEntity();

        authRoleEntity.setId( authRoleBo.getId() );
        authRoleEntity.setRoleName( authRoleBo.getRoleName() );
        authRoleEntity.setRoleKey( authRoleBo.getRoleKey() );
        authRoleEntity.setCreatedBy( authRoleBo.getCreatedBy() );
        authRoleEntity.setCreatedTime( authRoleBo.getCreatedTime() );
        authRoleEntity.setUpdateBy( authRoleBo.getUpdateBy() );
        authRoleEntity.setUpdateTime( authRoleBo.getUpdateTime() );
        authRoleEntity.setIsDeleted( authRoleBo.getIsDeleted() );

        return authRoleEntity;
    }

    @Override
    public List<AuthRoleBo> convertEntityToBoList(List<AuthRoleEntity> authRoleEntities) {
        if ( authRoleEntities == null ) {
            return null;
        }

        List<AuthRoleBo> list = new ArrayList<AuthRoleBo>( authRoleEntities.size() );
        for ( AuthRoleEntity authRoleEntity : authRoleEntities ) {
            list.add( authRoleEntityToAuthRoleBo( authRoleEntity ) );
        }

        return list;
    }

    protected AuthRoleBo authRoleEntityToAuthRoleBo(AuthRoleEntity authRoleEntity) {
        if ( authRoleEntity == null ) {
            return null;
        }

        AuthRoleBo authRoleBo = new AuthRoleBo();

        authRoleBo.setId( authRoleEntity.getId() );
        authRoleBo.setRoleName( authRoleEntity.getRoleName() );
        authRoleBo.setRoleKey( authRoleEntity.getRoleKey() );
        authRoleBo.setCreatedBy( authRoleEntity.getCreatedBy() );
        authRoleBo.setCreatedTime( authRoleEntity.getCreatedTime() );
        authRoleBo.setUpdateBy( authRoleEntity.getUpdateBy() );
        authRoleBo.setUpdateTime( authRoleEntity.getUpdateTime() );
        authRoleBo.setIsDeleted( authRoleEntity.getIsDeleted() );

        return authRoleBo;
    }
}
