package com.haowaner.controller;

import com.haowaner.config.SystemConfiguration;
import com.haowaner.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 用户控制器
 */
public class UserController {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //创建UserService对象
        /* UserService userService =(UserService) context.getBean(UserService.class);
        userService.find();
        context.close();*/
        //使用配置类的方式
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SystemConfiguration.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.haowaner");
        System.out.println(context);
        //获得bean
        UserService userService = (UserService) context.getBean("userService");
        userService.find();
        context.close();
    }
}
