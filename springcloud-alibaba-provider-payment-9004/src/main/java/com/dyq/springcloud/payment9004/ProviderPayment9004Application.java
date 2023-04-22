package com.dyq.springcloud.payment9004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPayment9004Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment9004Application.class, args);
    }

}
