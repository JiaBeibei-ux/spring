package com.haowaner.controller;

import com.haowaner.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 什么什么控制器
 */
public class AccountController {
    private ClassPathXmlApplicationContext context;
    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Test
    public void test(){
        AccountService accountService = (AccountService) context.getBean("accountService");
        accountService.transcation("Rose","Jack",1000.0);
    }

}
