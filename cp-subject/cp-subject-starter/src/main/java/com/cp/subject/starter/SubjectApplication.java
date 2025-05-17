package com.cp.subject.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/22 上午2:31
 **/
@SpringBootApplication
@ComponentScan("com.cp")
@MapperScan("com.cp.**.mapper")
@EnableFeignClients(basePackages = "com.cp")
public class SubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class);
    }
}
