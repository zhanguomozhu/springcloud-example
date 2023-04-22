package com.dyq.springcloud.payment8002;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.dyq.springcloud.payment8002.dao")
@EnableEurekaClient
@EnableDiscoveryClient
public class ProviderPayment8002Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment8002Application.class, args);
    }

}
