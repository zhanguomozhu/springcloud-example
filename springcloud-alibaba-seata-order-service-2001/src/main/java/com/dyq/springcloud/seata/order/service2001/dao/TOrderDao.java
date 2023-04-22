package com.dyq.springcloud.seata.order.service2001.dao;

import com.dyq.springcloud.seata.order.service2001.entity.TOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (TOrder)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-22 15:41:41
 */
public interface TOrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TOrder queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param tOrder   查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<TOrder> queryAllByLimit(TOrder tOrder, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tOrder 查询条件
     * @return 总行数
     */
    long count(TOrder tOrder);

    /**
     * 新增数据
     *
     * @param tOrder 实例对象
     * @return 影响行数
     */
    int insert(TOrder tOrder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TOrder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TOrder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TOrder> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TOrder> entities);

    /**
     * 修改数据
     *
     * @param tOrder 实例对象
     * @return 影响行数
     */
    int update(TOrder tOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

