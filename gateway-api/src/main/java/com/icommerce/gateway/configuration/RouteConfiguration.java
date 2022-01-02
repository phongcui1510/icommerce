package com.icommerce.gateway.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

    @Value("${product.service.url}")
    private String productService;

    @Value("${order.service.url}")
    private String orderService;

    @Value("${userlog.service.url}")
    private String userlogService;

    @Value("${cart.service.url}")
    private String cartService;

    @Bean
    public RouteLocator config(RouteLocatorBuilder builder, TokenRelayGatewayFilterFactory tokenRelay) {
        return builder.routes()
                .route("productService", p -> p.path( "/product-service/**").filters(f -> f.filter(tokenRelay.apply())).uri(productService))
                .route("orderService", p -> p.path("/order-service/**").filters(f -> f.filter(tokenRelay.apply())).uri(orderService))
                .route("userlogService", p -> p.path("/userlog-service/**").filters(f -> f.filter(tokenRelay.apply())).uri(userlogService))
                .route("cartService", p -> p.path("/cart-service/**").filters(f -> f.filter(tokenRelay.apply())).uri(cartService))
                .build();
    }
}
