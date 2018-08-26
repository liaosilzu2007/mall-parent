package com.lzumetal.mall.api.service;

import com.lzumetal.mall.api.dao.base.BaseDao;
import com.lzumetal.mall.api.dao.UserDao;
import com.lzumetal.mall.api.service.base.BaseServiceImpl;
import com.lzumetal.mall.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liaosi
 * @date 2018-08-26
 */
@Service
public class UserService extends BaseServiceImpl<User> {

    @Autowired
    private UserDao userDao;

    @Override
    protected BaseDao getDao() {
        return userDao;
    }


}
