package com.haowaner.test;


import com.haowaner.config.SystemConfiguration;
import com.haowaner.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * spring整合junit
 */
@RunWith(SpringJUnit4ClassRunner.class)//使用spring整合junit
@ContextConfiguration(classes = SystemConfiguration.class)//全文配置
public class SpringTest {
    @Autowired
    private UserService userService;
    //先写测试方法
    //加载配置类
    @Test
    public void test() throws Exception {

        userService.find();

    }
}
