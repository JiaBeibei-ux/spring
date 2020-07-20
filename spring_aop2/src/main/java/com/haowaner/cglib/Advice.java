package com.haowaner.cglib;

/**
 * 增强类 用来增强具体的方法
 */
public class Advice {
    //前值增强
    public void before(){
        System.out.println("前值增强");
    }
    //前值增强
    public void after() {
        System.out.println("后置增强");
    }
}
