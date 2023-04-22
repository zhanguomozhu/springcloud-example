package com.dyq.springcloud.seata.storage.service2002.service;

import com.dyq.springcloud.seata.storage.service2002.entity.TStorage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TStorage)表服务接口
 *
 * @author makejava
 * @since 2023-04-22 15:42:17
 */
public interface TStorageService {

    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);

}
