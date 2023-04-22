package com.dyq.springcloud.consul.order82;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulOrder82Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulOrder82Application.class, args);
    }

}
