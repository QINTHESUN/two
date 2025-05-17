package com.cp.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/30 下午4:11
 **/
@SpringBootApplication
@ComponentScan("com.cp")
public class WxApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxApplication.class);
    }
}
