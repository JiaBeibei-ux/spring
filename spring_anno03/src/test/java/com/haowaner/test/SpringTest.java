package com.haowaner.test;

import com.haowaner.config.SystemConfiguration;
import com.haowaner.domain.Target;
import com.haowaner.domain.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

/**
 * spring整合junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SystemConfiguration.class)
public class SpringTest {
    //使用jdk的动态代理 基于接口的 代理对象与目标对象应该是实现同一接口的两个兄弟类 但不可以是同一个
    @Autowired
    private TargetInterface target;
    @Test
    public void test(){
      target.save();
    }
    @Test
    public void test2() {
        List<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("2");
        linkedList.add("2");
        System.out.println(linkedList.get(1));
        for (String s : linkedList) {
            System.out.println(s);
        }
    }
}
