package com.haowaner.service.impl;

import com.haowaner.dao.UserDao;
import com.haowaner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务层实现类
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    //注入userDao
    @Autowired
    private UserDao userDao;
    //查询方法
    @Override
    public void find() throws Exception {
       userDao.find();
    }
}
