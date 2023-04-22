package com.dyq.springcloud.hygtrix.dashboard9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHygtrixDashboard9001Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHygtrixDashboard9001Application.class, args);
    }

}
