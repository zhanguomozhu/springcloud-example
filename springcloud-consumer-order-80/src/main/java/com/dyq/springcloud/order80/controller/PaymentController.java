package com.dyq.springcloud.order80.controller;

import com.dyq.springcloud.commons.entity.Payment;
import com.dyq.springcloud.commons.result.CommonResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * (Payment)表控制层
 *
 * @author makejava
 * @since 2023-04-19 14:09:26
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    //    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://SPRINGCLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public CommonResult<Payment> create(Payment payment) {
        System.out.println(payment.getSerial());
        return restTemplate.postForObject(PAYMENT_URL + "/payment", payment, CommonResult.class);
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, CommonResult.class);
    }
}

