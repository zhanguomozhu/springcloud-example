package com.dyq.springcloud.seata.order.service2001.service.impl;

import com.dyq.springcloud.seata.order.service2001.dao.TOrderDao;
import com.dyq.springcloud.seata.order.service2001.entity.TOrder;
import com.dyq.springcloud.seata.order.service2001.service.AccountService;
import com.dyq.springcloud.seata.order.service2001.service.StorageService;
import com.dyq.springcloud.seata.order.service2001.service.TOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (TOrder)表服务实现类
 *
 * @author makejava
 * @since 2023-04-22 15:41:43
 */
@Service("tOrderService")
@Slf4j
public class TOrderServiceImpl implements TOrderService {
    @Resource
    private TOrderDao orderDao;

    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说：下订单->扣库存->减余额->改状态
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(TOrder order)
    {
        log.info("----->开始新建订单");
        //1 新建订单
        orderDao.insert(order);

        //2 扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        //3 扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");

        //4 修改订单状态，从零到1,1代表已经完成
        log.info("----->修改订单状态开始");
        order.setStatus(1);
        orderDao.update(order);
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了，O(∩_∩)O哈哈~");

    }
}
