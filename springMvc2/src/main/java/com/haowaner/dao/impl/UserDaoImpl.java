package com.haowaner.dao.impl;

import com.haowaner.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * 用户持久层实现类
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save Running.....");
    }
}
