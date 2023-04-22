package com.dyq.springcloud.seata.account.service2003.service;

import java.math.BigDecimal;

/**
 * (TAccount)表服务接口
 *
 * @author makejava
 * @since 2023-04-22 15:42:55
 */
public interface TAccountService {

    void decrease(Long userId, BigDecimal money);

}
