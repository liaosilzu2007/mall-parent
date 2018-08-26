package com.lzumetal.mall.api.service.base;

import com.lzumetal.mall.api.dao.base.BaseDao;

import java.util.List;
import java.util.Map;

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
    public int updateByPrimaryKey(T entity) {
        return getDao().updateByPrimaryKey(entity);
    }

    @Override
    public T getByPrimaryKey(Long primaryKey) {
        return getDao().getByPrimaryKey(primaryKey);
    }

    @Override
    public List<T> getByPrimaryKeys(Long[] primaryKeys) {
        return getDao().getByPrimaryKeys(primaryKeys);
    }

    @Override
    public List<T> findAll(Map<String, Object> parameters) {
        return getDao().findAll(parameters);
    }
}
