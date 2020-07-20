package com.haowaner.dao.impl;

import com.haowaner.dao.UserDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    //c3p0数据源
    @Autowired
    private DataSource dataSource;

    @Value("${jdbc.driver}")
    private String dirver;
    //保存方法
    @Override
    public void find() throws Exception{
        System.out.println("dfffffff");
        System.out.println(dirver);
       //获得连接
        Connection connection = dataSource.getConnection();
        //得到预处理对象
        PreparedStatement ps = connection.prepareStatement("select * from sys_user");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("user_name")+","+rs.getString("user_password"));
        }
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化方法！");
    }
    @PreDestroy
    public void destory(){
        System.out.println("销毁方法！");
    }
}
