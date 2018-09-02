package com.lzumetal.mall.common.core.dao;

import com.lzumetal.mall.common.core.page.PageBean;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author liaosi
 * @date 2018-08-26
 */
public interface BaseDao<T> {


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


    /**
     * 根据条件查询
     *
     * @return 返回集合
     */
    List<T> listByParam(Map<String, Object> param);


    /**
     * 根据条件查询
     *
     * @param param
     * @return 返回实体
     */
    T getByParam(Map<String, Object> param);


    /**
     * 分页查询
     *
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageBean listPage(Map<String, Object> param, int pageNo, int pageSize);
}
