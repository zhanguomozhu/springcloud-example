package com.dyq.springcloud.zk.payment8004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderZkPayment8004Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderZkPayment8004Application.class, args);
    }

}
