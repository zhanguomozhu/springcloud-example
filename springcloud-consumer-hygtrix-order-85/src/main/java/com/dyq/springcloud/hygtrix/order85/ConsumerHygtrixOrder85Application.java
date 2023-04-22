package com.dyq.springcloud.hygtrix.order85;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ConsumerHygtrixOrder85Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHygtrixOrder85Application.class, args);
    }

}
