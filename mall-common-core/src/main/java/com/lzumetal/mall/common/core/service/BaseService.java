package com.lzumetal.mall.common.core.service;

import java.util.Collection;
import java.util.List;

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
    int updateById(T entity);

    /**
     * 按id查询
     *
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 按id查询
     *
     * @param ids
     * @return
     */
    List<T> getByIds(Collection<Long> ids);



}
