package com.haowaner.domain;

import com.haowaner.proxy.jdk.TargetInterface;
import org.springframework.stereotype.Component;

/**
 * 目标接口实现类
 */
@Component("target1")
public final class Target implements TargetInterface{
    //普通方法
    @Override
    public void save() {
        System.out.println("什么什么执行了。。。。。、");
    }
}
