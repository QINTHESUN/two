package com.cp.gateway.filter;

import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

/**
 * 登录拦截器
 *
 * @author: ChickenWing
 * @date: 2023/11/26
 */
@Component
@Slf4j
public class LoginFilter implements GlobalFilter {

    @Override
    @SneakyThrows
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        ServerHttpRequest.Builder mutate = request.mutate();
        String url = request.getURI().getPath();
        log.info("LoginFilter.filter.url:{}", url);
        if (url.equals("/auth/user/doLogin")) {
            return chain.filter(exchange);
        }
        List<String> satoken = request.getHeaders().get("satoken");
        //cookie里存的上一个人的token值，
        //请求头里拿token值，cookie存在还是上一个人的
         Object loginId = StpUtil.getLoginIdByToken(satoken.get(0));
       /*  if (Objects.isNull(loginId)){
             throw new SaTokenException("未授权");
         }*/
       // SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
     //   log.info("LoginFilter.filter.url:{}", new Gson().toJson(tokenInfo));
      //  String loginId = (String) tokenInfo.getLoginId();
        mutate.header("loginId", String.valueOf(loginId));
        return chain.filter(exchange.mutate().request(mutate.build()).build());
    }
}