package com.dyq.springcloud.seata.account.service2003.dao;

import com.dyq.springcloud.seata.account.service2003.entity.TAccount;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (TAccount)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-22 15:42:54
 */
public interface TAccountDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TAccount queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param tAccount 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<TAccount> queryAllByLimit(TAccount tAccount, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tAccount 查询条件
     * @return 总行数
     */
    long count(TAccount tAccount);

    /**
     * 新增数据
     *
     * @param tAccount 实例对象
     * @return 影响行数
     */
    int insert(TAccount tAccount);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TAccount> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TAccount> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TAccount> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TAccount> entities);

    /**
     * 修改数据
     *
     * @param tAccount 实例对象
     * @return 影响行数
     */
    int update(TAccount tAccount);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 根据用户id查询
     * @param userId
     * @return
     */
    TAccount queryByUserId(Long userId);
}

