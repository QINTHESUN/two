package com.cp.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/25 下午3:39
 **/
@SpringBootApplication
@ComponentScan("com.cp")
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class);
    }
}
