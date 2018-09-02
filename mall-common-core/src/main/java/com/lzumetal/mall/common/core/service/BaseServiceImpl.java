package com.lzumetal.mall.common.core.service;


import com.lzumetal.mall.common.core.dao.BaseDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author liaosi
 * @date 2018-08-26
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected abstract BaseDao<T> getDao();

    @Override
    public int insert(T entity) {
        return getDao().insert(entity);
    }

    @Override
    public int updateById(T entity) {
        return getDao().updateById(entity);
    }

    @Override
    public T getById(Long id) {
        if (id == null || id <= 0) {
            return null;
        }
        return getDao().getById(id);
    }

    @Override
    public List<T> getByIds(Collection ids) {
        if (ids == null || ids.isEmpty()) {
            return new ArrayList<>(2);
        }
        return getDao().getByIds(ids);
    }


}
