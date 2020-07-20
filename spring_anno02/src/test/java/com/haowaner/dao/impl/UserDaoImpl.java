package com.haowaner.dao.impl;

import com.haowaner.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 用户持久层接口
 */
@Repository
public class UserDaoImpl implements UserDao {
    //注入数据源
    @Autowired
    private DataSource dataSource;
    //查询方法
    @Override
    public void find() throws Exception {
        //获得连接
        Connection connection = dataSource.getConnection();
        //得到预处理对象
        PreparedStatement ps = connection.prepareStatement("select * from sys_user");
        //得到结果集
        ResultSet rs = ps.executeQuery();
        //遍历结果集
        while(rs.next()){
            System.out.println(rs.getString("user_name")+","+rs.getString("user_password"));
        }
    }
    //初始化方法
    @PostConstruct
    public void init(){
        System.out.println("这是个初始化方法。。。。");
    }
    //销毁方法
    @PreDestroy
    public void destory(){
        System.out.println("这是个销毁方法。。。。。");
    }
}
