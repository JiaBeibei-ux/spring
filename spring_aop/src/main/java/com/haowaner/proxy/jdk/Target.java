package com.haowaner.proxy.jdk;

/**
 * 目标接口实现类
 */
public final class Target implements TargetInterface{
    //普通方法
    @Override
    public void save() {
        System.out.println("什么什么执行了。。。。。、");
    }
}
