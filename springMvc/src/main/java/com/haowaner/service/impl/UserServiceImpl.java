package com.haowaner.service.impl;

import com.haowaner.dao.UserDao;
import com.haowaner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void save() {
        userDao.save();
    }
}
