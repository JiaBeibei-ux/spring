package com.haowaner.service.impl;

import com.haowaner.dao.UserDao;
import com.haowaner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    //调用userDao
    @Autowired
    private UserDao userDao;



    //查询
    @Override
    public void find() throws Exception{
        userDao.find();
    }
}
