package com.cp.auth.domain.convert;

import com.cp.auth.domain.bo.AuthUserBo;
import com.cp.auth.infra.basic.entity.AuthUserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:16:38+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class AuthUserBoConvertImpl implements AuthUserBoConvert {

    @Override
    public AuthUserEntity convertBoToEntity(AuthUserBo authUserBo) {
        if ( authUserBo == null ) {
            return null;
        }

        AuthUserEntity authUserEntity = new AuthUserEntity();

        authUserEntity.setId( authUserBo.getId() );
        authUserEntity.setUserName( authUserBo.getUserName() );
        authUserEntity.setNickName( authUserBo.getNickName() );
        authUserEntity.setEmail( authUserBo.getEmail() );
        authUserEntity.setPhone( authUserBo.getPhone() );
        authUserEntity.setPassword( authUserBo.getPassword() );
        authUserEntity.setSex( authUserBo.getSex() );
        authUserEntity.setAvatar( authUserBo.getAvatar() );
        authUserEntity.setStatus( authUserBo.getStatus() );
        authUserEntity.setIntroduce( authUserBo.getIntroduce() );
        authUserEntity.setExtJson( authUserBo.getExtJson() );
        authUserEntity.setCreatedBy( authUserBo.getCreatedBy() );
        authUserEntity.setCreatedTime( authUserBo.getCreatedTime() );
        authUserEntity.setUpdateBy( authUserBo.getUpdateBy() );
        authUserEntity.setUpdateTime( authUserBo.getUpdateTime() );
        authUserEntity.setIsDeleted( authUserBo.getIsDeleted() );

        return authUserEntity;
    }

    @Override
    public AuthUserBo convertEntityToBo(AuthUserEntity authUserEntity) {
        if ( authUserEntity == null ) {
            return null;
        }

        AuthUserBo authUserBo = new AuthUserBo();

        authUserBo.setId( authUserEntity.getId() );
        authUserBo.setUserName( authUserEntity.getUserName() );
        authUserBo.setNickName( authUserEntity.getNickName() );
        authUserBo.setEmail( authUserEntity.getEmail() );
        authUserBo.setPhone( authUserEntity.getPhone() );
        authUserBo.setPassword( authUserEntity.getPassword() );
        authUserBo.setSex( authUserEntity.getSex() );
        authUserBo.setAvatar( authUserEntity.getAvatar() );
        authUserBo.setStatus( authUserEntity.getStatus() );
        authUserBo.setIntroduce( authUserEntity.getIntroduce() );
        authUserBo.setExtJson( authUserEntity.getExtJson() );
        authUserBo.setCreatedBy( authUserEntity.getCreatedBy() );
        authUserBo.setCreatedTime( authUserEntity.getCreatedTime() );
        authUserBo.setUpdateBy( authUserEntity.getUpdateBy() );
        authUserBo.setUpdateTime( authUserEntity.getUpdateTime() );
        authUserBo.setIsDeleted( authUserEntity.getIsDeleted() );

        return authUserBo;
    }

    @Override
    public List<AuthUserBo> convertEntityListToBoList(List<AuthUserEntity> authUserEntities) {
        if ( authUserEntities == null ) {
            return null;
        }

        List<AuthUserBo> list = new ArrayList<AuthUserBo>( authUserEntities.size() );
        for ( AuthUserEntity authUserEntity : authUserEntities ) {
            list.add( convertEntityToBo( authUserEntity ) );
        }

        return list;
    }
}
