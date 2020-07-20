package com.haowaner.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class TestDataSources {

    //测试druid数据源
    @Test
    public void testDruid() throws Exception{
        //读取配置文件
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        //取出jdbc.properties 中的key
        String driver = resourceBundle.getString("jdbc.driver");
        String url = resourceBundle.getString("jdbc.url");
        String username = resourceBundle.getString("jdbc.username");
        String password = resourceBundle.getString("jdbc.password");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        //获得连接
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
    }
    //c3p0 方式二
    @Test
    public void testDruid2() throws Exception{
        //创建c3p0
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //设置参数
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        //获得连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
    //c3p0连接池
    @Test
    public void testC3p0() throws Exception{
        //读取配置文件
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        //获取配置文件中的属性
        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");
        //创建数据源
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        Connection connection = dataSource.getConnection();
        //查询数据
        PreparedStatement ps = connection.prepareStatement("select * from student");
        ResultSet rs = ps.executeQuery();
        //遍历结果集
        while(rs.next()){
            System.out.println(rs.getString("s_name")+","+rs.getString("s_age"));
        }
    }
    //dbcp 方式三
    @Test
    public void testDbcp() {
        //读取properties配置文件
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        //取出jdbc.properties 中的key
        String driver = resourceBundle.getString("jdbc.driver");
        String url = resourceBundle.getString("jdbc.url");
        String username = resourceBundle.getString("jdbc.username");
        String password = resourceBundle.getString("jdbc.password");
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
      /*  BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");*/
        try{
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        //查询方法
            PreparedStatement ps = connection.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("s_id")+","+rs.getString("s_name")+","+rs.getString("s_age"));
            }
            //普通方式插入
           /* PreparedStatement ps1 = connection.prepareStatement("insert into student (s_id,s_name,s_age) values (4,'Jack',20)");
            int i = ps1.executeUpdate();
            if(i>0){
                System.out.println("插入成功！");
            }*/
            //一对象的方式插入   现在没有对象 就不实现了
            //删除
            PreparedStatement ps2 = connection.prepareStatement("delete from student where s_id = 4 ");
            int delete = ps2.executeUpdate();
            if(delete>0){
                System.out.println("删除成功!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //spring整合druid
    @Test
    public void testSpringDruid() throws Exception{
        //读取配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获得数据源对象
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
