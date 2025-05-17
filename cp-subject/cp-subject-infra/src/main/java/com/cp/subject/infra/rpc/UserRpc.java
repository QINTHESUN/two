package com.cp.subject.infra.rpc;

import com.cp.api.auth.UserFeignService;
import com.cp.api.entity.AuthUserDto;
import com.cp.api.entity.Result;
import com.cp.subject.infra.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/11/1 上午11:01
 **/
@Component
@Slf4j
public class UserRpc {
    @Resource
    private UserFeignService userFeignService;

    public UserInfo getUserInfo(String userName) {
        AuthUserDto authUserDTO = new AuthUserDto();
        authUserDTO.setUserName(userName);
        log.info("authUserDTO:{}", authUserDTO);
        Result<AuthUserDto> result = userFeignService.getInfo(authUserDTO);
        UserInfo userInfo = new UserInfo();
        if (!result.getSuccess()) {
            return userInfo;
        }
        AuthUserDto data = result.getData();
        userInfo.setUserName(data.getUserName());
        userInfo.setNickName(data.getNickName());
        userInfo.setAvatar(data.getAvatar());
        return userInfo;

    }


}
