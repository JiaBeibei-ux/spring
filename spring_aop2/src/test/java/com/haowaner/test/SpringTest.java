package com.haowaner.test;

import com.haowaner.anno.SystemConfiguration;
import com.haowaner.aop.Target;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用spring整合junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(value = "classpath:applicationContext.xml")
@ContextConfiguration(classes = SystemConfiguration.class)
public class SpringTest {
    @Autowired
    private Target target;
    @Test
    public void test(){
      target.save();
    }
}
