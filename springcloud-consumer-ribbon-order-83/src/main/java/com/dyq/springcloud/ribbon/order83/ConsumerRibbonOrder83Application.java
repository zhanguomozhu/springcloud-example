package com.dyq.springcloud.ribbon.order83;

import com.dyq.springcloud.ribbon.order83.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SPRINGCLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
//@RibbonClient(name = "SPRINGCLOUD-PAYMENT-SERVICE")
public class ConsumerRibbonOrder83Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonOrder83Application.class, args);
    }

}
