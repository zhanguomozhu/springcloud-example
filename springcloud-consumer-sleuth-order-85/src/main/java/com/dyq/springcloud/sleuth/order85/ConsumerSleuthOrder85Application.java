package com.dyq.springcloud.sleuth.order85;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerSleuthOrder85Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerSleuthOrder85Application.class, args);
    }

}
