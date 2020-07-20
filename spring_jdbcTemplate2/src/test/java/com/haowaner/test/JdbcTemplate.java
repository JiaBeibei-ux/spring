package com.haowaner.test;

import com.haowaner.damain.Account;
import com.haowaner.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 测试使用spring整合junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplate {
    @Autowired
    private AccountService accountService;
    @Test
    public void test(){
        Account account = accountService.find("Jack");
        if(account==null){
            System.out.println("查询失败！");
        }
        System.out.println(account);
    }

}
