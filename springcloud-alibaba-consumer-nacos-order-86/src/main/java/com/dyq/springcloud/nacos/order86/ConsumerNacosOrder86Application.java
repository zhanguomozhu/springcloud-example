package com.dyq.springcloud.nacos.order86;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerNacosOrder86Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerNacosOrder86Application.class, args);
    }

}
