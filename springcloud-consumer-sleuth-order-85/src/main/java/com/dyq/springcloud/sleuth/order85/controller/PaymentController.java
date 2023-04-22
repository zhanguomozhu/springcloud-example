package com.dyq.springcloud.sleuth.order85.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * (Payment)表控制层
 *
 * @author makejava
 * @since 2023-04-19 14:09:26
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * zipkin+sleuth
     * @return
     */
    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://SPRINGCLOUD-PAYMENT-SERVICE:8009"+"/payment/zipkin", String.class);
        return result;
    }
}

