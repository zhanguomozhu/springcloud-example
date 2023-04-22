package com.dyq.springcloud.sleuth.payment8009.controller;

import org.springframework.web.bind.annotation.*;

/**
 * (Payment)表控制层
 *
 * @author makejava
 * @since 2023-04-21 13:54:55
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    @GetMapping("/zipkin")
    public String paymentZipkin() {
        return "hi ,i'am paymentzipkin server fall back，welcome to here, O(∩_∩)O哈哈~";
    }
}

