package com.dyq.springcloud.nacos.payment9002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderNacosPayment9002Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderNacosPayment9002Application.class, args);
    }

}
