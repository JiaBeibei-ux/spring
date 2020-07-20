package com.haowaner.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * jdbcTemplate测试类
 * 使用junit
 */
public class JdbcTemplateTest {
    @Test
    public void test() throws Exception {
        //使用c3p0数据源
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        //已经拿到jdbcTemplate模板了
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //注入数据源
        jdbcTemplate.setDataSource(dataSource);
        int i = jdbcTemplate.update("insert into account (id,name,money) values (null,?,?)", "Tom", 200.0);
        if(i>0){
            System.out.println("插入成功！");
        }
    }
}
