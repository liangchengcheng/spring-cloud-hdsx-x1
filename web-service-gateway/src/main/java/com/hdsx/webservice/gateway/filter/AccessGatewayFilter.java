package com.hdsx.webservice.gateway.filter;

import com.hdsx.webservice.redis.api.RedisServiceApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


import java.util.List;

/**
 * jkyishon - 移动开发部
 * 2019/08/15
 */
@Configuration
@Slf4j
public class AccessGatewayFilter implements GlobalFilter {

    @Autowired
    private RedisServiceApi redisServiceApi;

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, GatewayFilterChain gatewayFilterChain) {
        ServerHttpRequest request = serverWebExchange.getRequest();
        ServerHttpRequest.Builder mutate = request.mutate();
        String requestUri = request.getPath().pathWithinApplication().value();
        ServerHttpRequest build = mutate.build();
        // 不进行拦截的地址
        if (requestUri.contains("/v2/api-docs")
                || requestUri.contains("/userApi/login")
                || requestUri.contains("/redis")
                || requestUri.contains("/userApi/getVerificationCode")
                || requestUri.contains("/userApi/modifyUserPwdByMessage")) {
            return gatewayFilterChain.filter(serverWebExchange.mutate().request(build).build());
        }

        List<String> strings = request.getHeaders().get("token");
        String authToken = null;
        if (strings != null) {
            authToken = strings.get(0);
        }

        ServerHttpResponse response = serverWebExchange.getResponse();
        if (authToken == null || "".equals(authToken)) {
            log.error("token", "登录认证失效");
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        } else {
            boolean authsuccess = redisServiceApi.exists("web:" + authToken);
            if (!authsuccess) {
                log.error("token", "登录认证失效");
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }
        }

        return gatewayFilterChain.filter(serverWebExchange.mutate().request(build).build());
    }

}
