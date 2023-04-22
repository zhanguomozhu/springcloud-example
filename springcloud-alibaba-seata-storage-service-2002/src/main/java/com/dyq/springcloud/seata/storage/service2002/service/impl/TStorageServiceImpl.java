package com.dyq.springcloud.seata.storage.service2002.service.impl;

import com.dyq.springcloud.seata.storage.service2002.entity.TStorage;
import com.dyq.springcloud.seata.storage.service2002.dao.TStorageDao;
import com.dyq.springcloud.seata.storage.service2002.service.TStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TStorage)表服务实现类
 *
 * @author makejava
 * @since 2023-04-22 15:42:17
 */
@Service("tStorageService")
@Slf4j
public class TStorageServiceImpl implements TStorageService {
    @Resource
    private TStorageDao storageDao;
    /**
     * 扣减库存
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        TStorage storage = storageDao.queryByProductId(productId);
        storage.setResidue(storage.getResidue() - count);
        storage.setUsed(storage.getUsed() + count);
        storageDao.update(storage);
        log.info("------->storage-service中扣减库存结束");
    }
}
