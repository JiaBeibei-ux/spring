package com.haowaner.dao.impl;

import com.haowaner.dao.UserDao;
import com.haowaner.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

//用户持久层接口
public class UserDaoImpl implements UserDao {
    private String name;

    /*public void setName(String name) {
        this.name = name;
    }
*/
    private Properties properties;
    private List<String> list;

   /* public void setList(List<String> list) {
        this.list = list;
    }*/
    private Map<String, User> userMap;

   /* public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }*/
    private Map<String,String> map;
    public UserDaoImpl(String name, List<String> list, Map<String, User> userMap,Map<String,String> map,Properties properties) {
        this.name = name;
        this.list = list;
        this.userMap = userMap;
        this.map = map;
        this.properties=properties;
    }

    public UserDaoImpl(){
        System.out.println("userDaoImpl无参构造被创建了！");
    }


    public void init(){
        System.out.println("init>>>.>>");
    }
    //保存方法
    @Override
    public void save() {
        System.out.println(name);
        System.out.println(list);
        System.out.println(properties);
        System.out.println(map);
        System.out.println(userMap);
        System.out.println("Hello World!");
    }
}
