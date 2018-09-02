package com.lzumetal.mall.common.core.dao;

import com.github.pagehelper.PageRowBounds;
import com.lzumetal.mall.common.core.page.PageBean;
import com.lzumetal.mall.common.utils.GenericsUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author liaosi
 * @date 2018-08-26
 */
public abstract class AbstractBaseDao<T> extends SqlSessionDaoSupport implements BaseDao<T> {

    private static final String POSTFIX = "Dao";

    private static final String INSERT = ".insert";

    private static final String GET_BY_ID = ".getById";

    private static final String GET_BY_IDS = ".getByIds";

    private static final String UPDATE_BY_ID = ".updateById";

    private static final String LIST_BY_PARAM = ".listByParam";

    private static final String GET_BY_PARAM = ".getByParam";


    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }


    @SuppressWarnings({"unchecked", "rawtypes"})
    public String getNampSpace() {
        Class<T> clazz = (Class) GenericsUtils.getSuperClassGenricType(this.getClass());
        return clazz.getSimpleName() + POSTFIX;
    }


    @Override
    public int insert(T entity) {
        return getSqlSession().insert(this.getNampSpace() + INSERT, entity);
    }


    @Override
    public int updateById(T entity) {
        return getSqlSession().update(this.getNampSpace() + UPDATE_BY_ID, entity);
    }


    @Override
    public T getById(Long id) {
        return getSqlSession().selectOne(this.getNampSpace() + GET_BY_ID, id);
    }


    @Override
    public List<T> getByIds(Collection<Long> ids) {
        return getSqlSession().selectList(this.getNampSpace() + GET_BY_IDS, ids);
    }


    @Override
    public List<T> listByParam(Map<String, Object> param) {
        return getSqlSession().selectList(this.getNampSpace() + LIST_BY_PARAM, param);
    }


    @Override
    public T getByParam(Map<String, Object> param) {
        return getSqlSession().selectOne(this.getNampSpace() + GET_BY_PARAM, param);
    }


    @Override
    public PageBean listPage(Map<String, Object> param, int pageNo, int PageSize) {
        PageRowBounds rowBounds = new PageRowBounds((pageNo - 1) * PageSize, PageSize);
        List<T> results = getSqlSession().selectList(this.getNampSpace() + GET_BY_PARAM, param, rowBounds);
        return new PageBean<T>(pageNo, PageSize, rowBounds.getTotal(), results);
    }


}
