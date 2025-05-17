package com.cp.api.auth;

import com.cp.api.entity.AuthUserDto;
import com.cp.api.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/11/1 上午11:08
 **/
@FeignClient("cp-auth-dev")
public interface UserFeignService {

    @PostMapping("/auth/user/getInfo")
    public Result<AuthUserDto> getInfo(@RequestBody AuthUserDto authUserDto);


}
