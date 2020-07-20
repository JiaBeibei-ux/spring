package com.haowaner.aop;

import org.springframework.stereotype.Component;

/**
 * 普通实现类
 *  目标类
 * <bean id="target" class="com.haowaner.aop.Target"></bean>
 */
@Component("target")
public class Target{
    //普通方法
    public void save() {
        System.out.println("什么什么执行了。。。。。、");
    }
}
