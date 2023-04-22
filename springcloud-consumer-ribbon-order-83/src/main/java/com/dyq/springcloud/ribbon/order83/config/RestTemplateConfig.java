package com.dyq.springcloud.ribbon.order83.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /**
     * 使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
     */
    @Bean
    //使用自定义策略时注释掉
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
