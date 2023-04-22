package com.dyq.springcloud.zk.order81;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZkOrder81Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerZkOrder81Application.class, args);
    }

}
