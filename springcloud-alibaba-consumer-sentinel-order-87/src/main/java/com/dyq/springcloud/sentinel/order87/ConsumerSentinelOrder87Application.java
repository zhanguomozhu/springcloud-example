package com.dyq.springcloud.sentinel.order87;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ConsumerSentinelOrder87Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerSentinelOrder87Application.class, args);
    }

}
