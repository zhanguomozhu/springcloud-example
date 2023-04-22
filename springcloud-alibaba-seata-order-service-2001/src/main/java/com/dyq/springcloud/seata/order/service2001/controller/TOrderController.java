package com.dyq.springcloud.seata.order.service2001.controller;

import com.dyq.springcloud.commons.result.CommonResult;
import com.dyq.springcloud.seata.order.service2001.entity.TOrder;
import com.dyq.springcloud.seata.order.service2001.service.TOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TOrder)表控制层
 *
 * @author makejava
 * @since 2023-04-22 15:41:41
 */
@RestController
@RequestMapping("order")
public class TOrderController {
    /**
     * 服务对象
     */
    @Resource
    private TOrderService orderService;


    @GetMapping("/create")
    public CommonResult create(TOrder order)
    {
        orderService.create(order);
        return CommonResult.success("订单创建成功");
    }
}

