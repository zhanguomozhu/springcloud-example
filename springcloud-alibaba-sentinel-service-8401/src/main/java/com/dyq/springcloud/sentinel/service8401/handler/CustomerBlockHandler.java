package com.dyq.springcloud.sentinel.service8401.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dyq.springcloud.commons.result.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return CommonResult.failed("按客戶自定义,global handlerException----1");
    }
    
    public static CommonResult handlerException2(BlockException exception) {
        return CommonResult.failed("按客戶自定义,global handlerException----2");
    }
}
