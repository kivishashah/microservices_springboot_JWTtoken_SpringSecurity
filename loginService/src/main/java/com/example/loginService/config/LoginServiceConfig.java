package com.example.loginService.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LoginServiceConfig {

    @Bean
    @LoadBalanced
    public RestTemplate template(){
        return new RestTemplate();
    }
}