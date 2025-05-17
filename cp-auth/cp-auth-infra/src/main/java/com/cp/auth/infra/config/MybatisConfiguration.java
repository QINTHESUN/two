package com.cp.auth.infra.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 11/9/2024 上午 10:36
 **/

@Configuration
public class MybatisConfiguration {


    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new MybatisPlusAllSqlLog());
        return interceptor;
    }


}
