package com.lzumetal.mall.api.service.base;

import java.util.List;
import java.util.Map;

/**
 * @author liaosi
 * @date 2018-08-26
 */
public interface BaseService<T> {

    /**
     * 新增
     *
     * @param entity
     */
    int insert(T entity);


    /**
     * 更新
     *
     * @param entity
     */
    int updateByPrimaryKey(T entity);

    /**
     * 按id查询
     *
     * @param primaryKey
     * @return
     */
    T getByPrimaryKey(Long primaryKey);

    /**
     * 按id查询
     *
     * @param primaryKeys
     * @return
     */
    List<T> getByPrimaryKeys(Long[] primaryKeys);

    /**
     * 查询所有
     *
     * @return
     */
    List<T> findAll(Map<String, Object> parameters);

}
