package com.example.authclient.config;

import org.springframework.cloud.gateway.server.mvc.filter.TokenRelayFilterFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
class ClientConfig {

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return route()
                .filter(TokenRelayFilterFunctions.tokenRelay())
                .GET("/**", http("http://localhost:8080"))
                .build();
    }
}
