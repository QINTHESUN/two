package com.cp.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/24 下午2:20
 **/
@SpringBootApplication
@ComponentScan("com.cp")
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class);
    }
}
