package com.skg.foodCatelogue.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

   // String baseUrl = "http://YP1100837LT.Yash.com:5001";

    @Bean
    @LoadBalanced
    public WebClient webClient() {
        return WebClient
                .builder()
            //    .baseUrl(baseUrl)
                .build();
    }

}
