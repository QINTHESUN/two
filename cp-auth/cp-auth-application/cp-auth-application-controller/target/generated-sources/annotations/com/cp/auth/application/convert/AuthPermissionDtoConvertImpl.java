package com.cp.auth.application.convert;

import com.cp.auth.application.dto.AuthPermissionDto;
import com.cp.auth.domain.bo.AuthPermissionBo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:16:42+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class AuthPermissionDtoConvertImpl implements AuthPermissionDtoConvert {

    @Override
    public AuthPermissionBo convertDtoToBo(AuthPermissionDto dto) {
        if ( dto == null ) {
            return null;
        }

        AuthPermissionBo authPermissionBo = new AuthPermissionBo();

        authPermissionBo.setId( dto.getId() );
        authPermissionBo.setName( dto.getName() );
        authPermissionBo.setParentId( dto.getParentId() );
        authPermissionBo.setType( dto.getType() );
        authPermissionBo.setMenuUrl( dto.getMenuUrl() );
        authPermissionBo.setStatus( dto.getStatus() );
        authPermissionBo.setShow( dto.getShow() );
        authPermissionBo.setIcon( dto.getIcon() );
        authPermissionBo.setPermissionKey( dto.getPermissionKey() );
        authPermissionBo.setCreatedBy( dto.getCreatedBy() );
        authPermissionBo.setCreatedTime( dto.getCreatedTime() );
        authPermissionBo.setUpdateBy( dto.getUpdateBy() );
        authPermissionBo.setUpdateTime( dto.getUpdateTime() );
        authPermissionBo.setIsDeleted( dto.getIsDeleted() );

        return authPermissionBo;
    }

    @Override
    public List<AuthPermissionDto> convertBoToDtoList(List<AuthPermissionBo> boList) {
        if ( boList == null ) {
            return null;
        }

        List<AuthPermissionDto> list = new ArrayList<AuthPermissionDto>( boList.size() );
        for ( AuthPermissionBo authPermissionBo : boList ) {
            list.add( authPermissionBoToAuthPermissionDto( authPermissionBo ) );
        }

        return list;
    }

    protected AuthPermissionDto authPermissionBoToAuthPermissionDto(AuthPermissionBo authPermissionBo) {
        if ( authPermissionBo == null ) {
            return null;
        }

        AuthPermissionDto authPermissionDto = new AuthPermissionDto();

        authPermissionDto.setId( authPermissionBo.getId() );
        authPermissionDto.setName( authPermissionBo.getName() );
        authPermissionDto.setParentId( authPermissionBo.getParentId() );
        authPermissionDto.setType( authPermissionBo.getType() );
        authPermissionDto.setMenuUrl( authPermissionBo.getMenuUrl() );
        authPermissionDto.setStatus( authPermissionBo.getStatus() );
        authPermissionDto.setShow( authPermissionBo.getShow() );
        authPermissionDto.setIcon( authPermissionBo.getIcon() );
        authPermissionDto.setPermissionKey( authPermissionBo.getPermissionKey() );
        authPermissionDto.setCreatedBy( authPermissionBo.getCreatedBy() );
        authPermissionDto.setCreatedTime( authPermissionBo.getCreatedTime() );
        authPermissionDto.setUpdateBy( authPermissionBo.getUpdateBy() );
        authPermissionDto.setUpdateTime( authPermissionBo.getUpdateTime() );
        authPermissionDto.setIsDeleted( authPermissionBo.getIsDeleted() );

        return authPermissionDto;
    }
}
