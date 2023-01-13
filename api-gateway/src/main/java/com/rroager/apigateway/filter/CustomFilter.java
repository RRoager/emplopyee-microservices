package com.rroager.apigateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class CustomFilter implements GlobalFilter {

    Logger logger = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // Pre-filter. Logs authorization header
        ServerHttpRequest request = exchange.getRequest();

        // Make a request for a specific microservice
        /*
        if (request.getURI().toString().contains("api/employee")) {

        }
        */

        logger.info("Authorization = " + request.getHeaders().getFirst("Authorization"));

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            // Post-filter. Logs status code
            ServerHttpResponse response = exchange.getResponse();
            logger.info("Post Filter = " + response.getStatusCode());
        }));
    }
}
