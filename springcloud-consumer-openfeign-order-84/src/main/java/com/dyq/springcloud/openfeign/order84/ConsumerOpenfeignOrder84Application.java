package com.dyq.springcloud.openfeign.order84;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerOpenfeignOrder84Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOpenfeignOrder84Application.class, args);
    }

}
