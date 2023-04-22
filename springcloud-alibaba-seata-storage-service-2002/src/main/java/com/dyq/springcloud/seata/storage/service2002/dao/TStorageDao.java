package com.dyq.springcloud.seata.storage.service2002.dao;

import com.dyq.springcloud.seata.storage.service2002.entity.TStorage;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (TStorage)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-22 16:13:39
 */
public interface TStorageDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TStorage queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param tStorage 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<TStorage> queryAllByLimit(TStorage tStorage, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tStorage 查询条件
     * @return 总行数
     */
    long count(TStorage tStorage);

    /**
     * 新增数据
     *
     * @param tStorage 实例对象
     * @return 影响行数
     */
    int insert(TStorage tStorage);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TStorage> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TStorage> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TStorage> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TStorage> entities);

    /**
     * 修改数据
     *
     * @param tStorage 实例对象
     * @return 影响行数
     */
    int update(TStorage tStorage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TStorage queryByProductId(Long id);

}

