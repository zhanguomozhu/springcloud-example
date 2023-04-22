package com.dyq.springcloud.seata.account.service2003.service.impl;

import com.dyq.springcloud.seata.account.service2003.entity.TAccount;
import com.dyq.springcloud.seata.account.service2003.dao.TAccountDao;
import com.dyq.springcloud.seata.account.service2003.service.TAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * (TAccount)表服务实现类
 *
 * @author makejava
 * @since 2023-04-22 15:42:55
 */
@Service("tAccountService")
@Slf4j
public class TAccountServiceImpl implements TAccountService {
    @Resource
    private TAccountDao accountDao;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        try { TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
        TAccount account = accountDao.queryByUserId(userId);
        account.setUsed(account.getUsed().add(money));
        account.setResidue(account.getResidue().subtract(money));
        accountDao.update(account);
        log.info("------->account-service中扣减账户余额结束");
    }
}
