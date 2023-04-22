package com.dyq.springcloud.nacos.payment9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderNacosPayment9001Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderNacosPayment9001Application.class, args);
    }

}
