package com.dyq.springcloud.sentinel.order87.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dyq.springcloud.commons.entity.Payment;
import com.dyq.springcloud.commons.result.CommonResult;
import com.dyq.springcloud.sentinel.order87.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;


    /**
     * 服务熔断无配置
     * @param id
     * @return
     */
    @RequestMapping("/consumer/fallback1/{id}")
    @SentinelResource(value = "fallback")//没有配置
    public CommonResult<Payment> fallback1(@PathVariable Long id)
    {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id,CommonResult.class,id);

        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }


    /**
     * 服务熔断只配置fallback
     * @param id
     * @return
     */
    @RequestMapping("/consumer/fallback2/{id}")
    @SentinelResource(value = "fallback", fallback = "handlerFallback1") //fallback只负责业务异常
    public CommonResult<Payment> fallback2(@PathVariable Long id)
    {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id,CommonResult.class,id);

        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }

    /**
     * fallback
     * @param id
     * @param e
     * @return
     */
    public CommonResult handlerFallback1(@PathVariable  Long id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return CommonResult.success(payment,"兜底异常handlerFallback,exception内容  "+e.getMessage());
    }


    /**
     * 服务熔断只配置blockHandler
     * @param id
     * @return
     */
    @RequestMapping("/consumer/block/{id}")
    @SentinelResource(value = "fallback",blockHandler = "blockHandler1") //blockHandler只负责sentinel控制台配置违规
    public CommonResult<Payment> block(@PathVariable Long id)
    {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id,CommonResult.class,id);

        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }

    /**
     * blockHandler
     * @param id
     * @param blockException
     * @return
     */
    public CommonResult blockHandler1(@PathVariable  Long id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return CommonResult.success(payment,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage());
    }


    /**
     * 服务熔断fallback和blockHandler都配置
     * @param id
     * @return
     */
    @RequestMapping("/consumer/fallback3/{id}")
    @SentinelResource(value = "fallback",fallback = "handlerFallback2",blockHandler = "blockHandler2")
    public CommonResult<Payment> fallback3(@PathVariable Long id)
    {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id,CommonResult.class,id);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }

    /**
     * fallback
     * @param id
     * @param e
     * @return
     */
    public CommonResult handlerFallback2(@PathVariable  Long id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return CommonResult.success(payment,"兜底异常handlerFallback,exception内容  "+e.getMessage());
    }

    /**
     * blockHandler
     * @param id
     * @param blockException
     * @return
     */
    public CommonResult blockHandler2(@PathVariable  Long id,BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return CommonResult.success(payment,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage());
    }


    /**
     * 服务熔断exceptionsToIgnore
     * @param id
     * @return
     */
    @RequestMapping("/consumer/fallback4/{id}")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})//<-------------
    public CommonResult<Payment> fallback4(@PathVariable Long id)
    {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id,CommonResult.class,id);
        if (id == 4) {
            //exceptionsToIgnore属性有IllegalArgumentException.class，
            //所以IllegalArgumentException不会跳入指定的兜底程序。
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }


    /**
     * OpenFeign
     */
    @Resource
    private PaymentService paymentService;


    /**
     * OpenFeign服务熔断
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id)
    {
        return paymentService.paymentSQL(id);
    }
}
