package com.dyq.springcloud.seata.account.service2003.controller;

import com.dyq.springcloud.commons.result.CommonResult;
import com.dyq.springcloud.seata.account.service2003.entity.TAccount;
import com.dyq.springcloud.seata.account.service2003.service.TAccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * (TAccount)表控制层
 *
 * @author makejava
 * @since 2023-04-22 15:42:54
 */
@RestController
@RequestMapping("account")
public class TAccountController {
    /**
     * 服务对象
     */
    @Resource
    private TAccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);
        return CommonResult.success("扣减账户余额成功！");
    }
}

