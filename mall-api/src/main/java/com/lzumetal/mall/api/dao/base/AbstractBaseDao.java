package com.lzumetal.mall.api.dao.base;

import com.lzumetal.mall.common.utils.GenericsUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author liaosi
 * @date 2018-08-26
 */
public abstract class AbstractBaseDao<T> extends SqlSessionDaoSupport implements BaseDao<T> {

    private static final String POSTFIX = "Dao";

    private static final String INSERT = ".insert";

    private static final String GET_BY_PRIMARY_KEY = ".getByPrimaryKey";

    private static final String UPDATE_BY_PRIMARY_KEY = ".updateByPrimaryKey";

    private static final String FIND_ALL = ".findAll";



    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    public String getNampSpace() {
        Class<T> clazz = (Class) GenericsUtils.getSuperClassGenricType(this.getClass());
        return clazz.getSimpleName() + POSTFIX;
    }


    @Override
    public int insert(T entity) {
        return getSqlSession().insert(this.getNampSpace() + INSERT, entity);
    }

    @Override
    public int updateByPrimaryKey(T entity) {
        return getSqlSession().update(this.getNampSpace() + UPDATE_BY_PRIMARY_KEY, entity);
    }

    @Override
    public T getByPrimaryKey(Long primaryKey) {
        return getSqlSession().selectOne(this.getNampSpace() + GET_BY_PRIMARY_KEY, primaryKey);
    }

    @Override
    public List<T> getByPrimaryKeys(Long[] primaryKeys) {
        return getSqlSession().selectList(this.getNampSpace() + GET_BY_PRIMARY_KEY, primaryKeys);
    }

    @Override
    public List<T> findAll(Map<String, Object> parameters) {
        return getSqlSession().selectList(this.getNampSpace() + FIND_ALL, parameters);
    }
}
