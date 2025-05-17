package com.cp.auth.application.convert;

import com.cp.api.entity.AuthUserDto;
import com.cp.auth.domain.bo.AuthUserBo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T20:16:42+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class AuthUserDtoConvertImpl implements AuthUserDtoConvert {

    @Override
    public AuthUserBo convertDtoToBo(AuthUserDto dto) {
        if ( dto == null ) {
            return null;
        }

        AuthUserBo authUserBo = new AuthUserBo();

        authUserBo.setId( dto.getId() );
        authUserBo.setUserName( dto.getUserName() );
        authUserBo.setNickName( dto.getNickName() );
        authUserBo.setEmail( dto.getEmail() );
        authUserBo.setPhone( dto.getPhone() );
        authUserBo.setPassword( dto.getPassword() );
        authUserBo.setSex( dto.getSex() );
        authUserBo.setAvatar( dto.getAvatar() );
        authUserBo.setStatus( dto.getStatus() );
        authUserBo.setIntroduce( dto.getIntroduce() );
        authUserBo.setExtJson( dto.getExtJson() );
        authUserBo.setCreatedBy( dto.getCreatedBy() );
        authUserBo.setCreatedTime( dto.getCreatedTime() );
        authUserBo.setUpdateBy( dto.getUpdateBy() );
        authUserBo.setUpdateTime( dto.getUpdateTime() );
        authUserBo.setIsDeleted( dto.getIsDeleted() );

        return authUserBo;
    }

    @Override
    public AuthUserDto convertBoToDto(AuthUserBo bo) {
        if ( bo == null ) {
            return null;
        }

        AuthUserDto authUserDto = new AuthUserDto();

        authUserDto.setId( bo.getId() );
        authUserDto.setUserName( bo.getUserName() );
        authUserDto.setNickName( bo.getNickName() );
        authUserDto.setEmail( bo.getEmail() );
        authUserDto.setPhone( bo.getPhone() );
        authUserDto.setPassword( bo.getPassword() );
        authUserDto.setSex( bo.getSex() );
        authUserDto.setAvatar( bo.getAvatar() );
        authUserDto.setStatus( bo.getStatus() );
        authUserDto.setIntroduce( bo.getIntroduce() );
        authUserDto.setExtJson( bo.getExtJson() );
        authUserDto.setCreatedBy( bo.getCreatedBy() );
        authUserDto.setCreatedTime( bo.getCreatedTime() );
        authUserDto.setUpdateBy( bo.getUpdateBy() );
        authUserDto.setUpdateTime( bo.getUpdateTime() );
        authUserDto.setIsDeleted( bo.getIsDeleted() );

        return authUserDto;
    }

    @Override
    public List<AuthUserDto> convertBoListToDtoList(List<AuthUserBo> boList) {
        if ( boList == null ) {
            return null;
        }

        List<AuthUserDto> list = new ArrayList<AuthUserDto>( boList.size() );
        for ( AuthUserBo authUserBo : boList ) {
            list.add( convertBoToDto( authUserBo ) );
        }

        return list;
    }
}
