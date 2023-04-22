package com.dyq.springcloud.sentinel.order87.service;

import com.dyq.springcloud.commons.entity.Payment;
import com.dyq.springcloud.commons.result.CommonResult;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id)
    {
        return CommonResult.success(new Payment(id,"errorSerial"),"服务降级返回,---PaymentFallbackService");
    }
}

