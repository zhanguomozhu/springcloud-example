package com.dyq.springcloud.config3366;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Config3366Application {

    public static void main(String[] args) {
        SpringApplication.run(Config3366Application.class, args);
    }

}
