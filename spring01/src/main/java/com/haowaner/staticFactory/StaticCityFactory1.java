package com.haowaner.staticFactory;


import com.haowaner.dao.UserDao;
import com.haowaner.dao.impl.UserDaoImpl;

public class StaticCityFactory1 {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
