package com.dyq.springcloud.sleuth.payment8009;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.dyq.springcloud.sleuth.payment8009.dao")
@EnableEurekaClient
@EnableDiscoveryClient
public class ProviderSleuthPayment8009Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderSleuthPayment8009Application.class, args);
    }

}
