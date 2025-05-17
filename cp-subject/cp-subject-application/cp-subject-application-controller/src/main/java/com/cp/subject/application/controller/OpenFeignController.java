package com.cp.subject.application.controller;

import com.cp.subject.infra.entity.UserInfo;
import com.cp.subject.infra.rpc.UserRpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/11/1 上午11:29
 **/
@RestController
@Slf4j
public class OpenFeignController {

    @Resource
    private UserRpc userRpc;


    @GetMapping("/testFeign")
    public void testFeign(){
        UserInfo userInfo = userRpc.getUserInfo("qqq");
        log.info("testFeign userInfo:{}", userInfo);
    }

}
