package com.dyq.springcloud.seata.storage.service2002.controller;

import com.dyq.springcloud.commons.result.CommonResult;
import com.dyq.springcloud.seata.storage.service2002.entity.TStorage;
import com.dyq.springcloud.seata.storage.service2002.service.TStorageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TStorage)表控制层
 *
 * @author makejava
 * @since 2023-04-22 15:42:16
 */
@RestController
@RequestMapping("storage")
public class TStorageController {
    /**
     * 服务对象
     */
    @Resource
    private TStorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return CommonResult.success("扣减库存成功！");
    }
}

