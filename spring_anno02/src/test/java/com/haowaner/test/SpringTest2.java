package com.haowaner.test;

import com.haowaner.config.SystemConfiguration;
import com.haowaner.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 练习spring整合junit
 */
@RunWith(SpringJUnit4ClassRunner.class)//加载spring整合junit
@ContextConfiguration(classes = SystemConfiguration.class)//全局文件扫描
public class SpringTest2 {
    //自动装配UserService
    @Autowired
    private UserService userService;
    //编写测试方法
    @Test
    public void test() throws Exception {
        userService.find();
    }
}
