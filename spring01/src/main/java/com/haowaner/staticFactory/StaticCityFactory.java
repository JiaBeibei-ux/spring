package com.haowaner.staticFactory;


import com.haowaner.dao.UserDao;
import com.haowaner.dao.impl.UserDaoImpl;

public class StaticCityFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
