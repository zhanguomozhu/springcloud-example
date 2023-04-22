package com.dyq.springcloud.ribbon.order83.controller;

import com.dyq.springcloud.commons.entity.Payment;
import com.dyq.springcloud.commons.result.CommonResult;
import com.dyq.springcloud.ribbon.order83.config.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/getForEntity/{id}")
    public CommonResult getPayment2(@PathVariable("id") Long id)
    {
//        String PAYMENT_URL = "http://localhost:8001";
        System.out.println(PAYMENT_URL+"/payment/"+id);
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/"+id,CommonResult.class);

        if(entity.getStatusCode().is2xxSuccessful()){
            //getForObject()
            return entity.getBody();
        }else{
            return CommonResult.failed("操作失败");
        }
    }




    @Autowired
    private LoadBalancer loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/lb")
    public String getPaymentLB()
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

}

