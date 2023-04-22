package com.dyq.springcloud.payment8001.service.impl;

import com.dyq.springcloud.commons.entity.Payment;
import com.dyq.springcloud.payment8001.dao.PaymentDao;
import com.dyq.springcloud.payment8001.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * (Payment)表服务实现类
 *
 * @author makejava
 * @since 2023-04-19 09:05:43
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Payment queryById(Long id) {
        return this.paymentDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param payment     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Payment> queryByPage(Payment payment, PageRequest pageRequest) {
        long total = this.paymentDao.count(payment);
        return new PageImpl<>(this.paymentDao.queryAllByLimit(payment, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public Payment insert(Payment payment) {
        this.paymentDao.insert(payment);
        return payment;
    }

    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public Payment update(Payment payment) {
        this.paymentDao.update(payment);
        return this.queryById(payment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.paymentDao.deleteById(id) > 0;
    }
}
