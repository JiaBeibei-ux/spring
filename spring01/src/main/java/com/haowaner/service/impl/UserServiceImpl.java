package com.haowaner.service.impl;

import com.haowaner.dao.UserDao;
import com.haowaner.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {
   private UserDao userDao;

   /* public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
*/

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    //保存方法
    @Override
    public void save() {
        //有点问题的写发  service 调用dao
      /*  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.save();*/
      //没有创建对象
        userDao.save();
    }
}
