package com.haowaner.controller;

import com.haowaner.config.SystemConfiguration;
import com.haowaner.service.UserService;
import com.haowaner.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 系统控制器
 */
public class SystemController {
    //使用junit测试
    @Test
    public void test() throws Exception {
        //加载配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SystemConfiguration.class);
        UserService userService = (UserService) context.getBean("userServiceImpl");
        userService.find();
        context.close();
    }
}
