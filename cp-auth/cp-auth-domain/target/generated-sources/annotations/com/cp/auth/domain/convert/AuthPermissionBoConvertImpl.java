package com.cp.auth.domain.convert;

import com.cp.auth.domain.bo.AuthPermissionBo;
import com.cp.auth.infra.basic.entity.AuthPermissionEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:16:38+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class AuthPermissionBoConvertImpl implements AuthPermissionBoConvert {

    @Override
    public AuthPermissionEntity convertBoToEntity(AuthPermissionBo authPermissionBo) {
        if ( authPermissionBo == null ) {
            return null;
        }

        AuthPermissionEntity authPermissionEntity = new AuthPermissionEntity();

        authPermissionEntity.setId( authPermissionBo.getId() );
        authPermissionEntity.setName( authPermissionBo.getName() );
        authPermissionEntity.setParentId( authPermissionBo.getParentId() );
        authPermissionEntity.setType( authPermissionBo.getType() );
        authPermissionEntity.setMenuUrl( authPermissionBo.getMenuUrl() );
        authPermissionEntity.setStatus( authPermissionBo.getStatus() );
        authPermissionEntity.setShow( authPermissionBo.getShow() );
        authPermissionEntity.setIcon( authPermissionBo.getIcon() );
        authPermissionEntity.setPermissionKey( authPermissionBo.getPermissionKey() );
        authPermissionEntity.setCreatedBy( authPermissionBo.getCreatedBy() );
        authPermissionEntity.setCreatedTime( authPermissionBo.getCreatedTime() );
        authPermissionEntity.setUpdateBy( authPermissionBo.getUpdateBy() );
        authPermissionEntity.setUpdateTime( authPermissionBo.getUpdateTime() );
        authPermissionEntity.setIsDeleted( authPermissionBo.getIsDeleted() );

        return authPermissionEntity;
    }

    @Override
    public List<AuthPermissionBo> convertEntityToBoList(List<AuthPermissionEntity> authPermissionEntities) {
        if ( authPermissionEntities == null ) {
            return null;
        }

        List<AuthPermissionBo> list = new ArrayList<AuthPermissionBo>( authPermissionEntities.size() );
        for ( AuthPermissionEntity authPermissionEntity : authPermissionEntities ) {
            list.add( authPermissionEntityToAuthPermissionBo( authPermissionEntity ) );
        }

        return list;
    }

    protected AuthPermissionBo authPermissionEntityToAuthPermissionBo(AuthPermissionEntity authPermissionEntity) {
        if ( authPermissionEntity == null ) {
            return null;
        }

        AuthPermissionBo authPermissionBo = new AuthPermissionBo();

        authPermissionBo.setId( authPermissionEntity.getId() );
        authPermissionBo.setName( authPermissionEntity.getName() );
        authPermissionBo.setParentId( authPermissionEntity.getParentId() );
        authPermissionBo.setType( authPermissionEntity.getType() );
        authPermissionBo.setMenuUrl( authPermissionEntity.getMenuUrl() );
        authPermissionBo.setStatus( authPermissionEntity.getStatus() );
        authPermissionBo.setShow( authPermissionEntity.getShow() );
        authPermissionBo.setIcon( authPermissionEntity.getIcon() );
        authPermissionBo.setPermissionKey( authPermissionEntity.getPermissionKey() );
        authPermissionBo.setCreatedBy( authPermissionEntity.getCreatedBy() );
        authPermissionBo.setCreatedTime( authPermissionEntity.getCreatedTime() );
        authPermissionBo.setUpdateBy( authPermissionEntity.getUpdateBy() );
        authPermissionBo.setUpdateTime( authPermissionEntity.getUpdateTime() );
        authPermissionBo.setIsDeleted( authPermissionEntity.getIsDeleted() );

        return authPermissionBo;
    }
}
