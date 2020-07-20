package com.haowaner.test;

import com.haowaner.damian.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * 使用spring整合jdbcTemplate
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class JdbcTemplateTest2 {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Before
    public void init(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate =(JdbcTemplate) context.getBean("jdbcTemplate");
    }
    //增加
    @Test
    public void test(){
        int i = jdbcTemplate.update("insert into account (id,name,money) values (null,?,?)", "Jack", 5000.0);
        if(i<0){
            System.out.println("插入失败！");
        }
    }
    //删除
    @Test
    public void test2(){
        int i = jdbcTemplate.update("delete from account where id = ?",1);
        if(i<0){
            System.out.println("插入失败！");
        }
    }
    //修改
    @Test
    public void test3(){
        int i = jdbcTemplate.update("update account set name = ? where id = ?","Rose",2);
        if(i<0){
            System.out.println("插入失败！");
        }
    }
    //查询所有
    @Test
    public void test4(){
        List<Account> list = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(list);
    }
    //查询一条
    @Test
    public void test5(){
        Account account = jdbcTemplate.queryForObject("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), 2);
        System.out.println(account);
    }
    //聚合函数查询
    @Test
    public void test6(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(aLong);
    }
    //查询
    @Test
    public void test7(){
        List<Account> list = jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println();
    }

}
