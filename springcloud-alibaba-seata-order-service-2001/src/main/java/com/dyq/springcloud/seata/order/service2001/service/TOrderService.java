package com.dyq.springcloud.seata.order.service2001.service;

import com.dyq.springcloud.seata.order.service2001.entity.TOrder;

/**
 * (TOrder)表服务接口
 *
 * @author makejava
 * @since 2023-04-22 15:41:43
 */
public interface TOrderService {

    void create(TOrder order);
}
