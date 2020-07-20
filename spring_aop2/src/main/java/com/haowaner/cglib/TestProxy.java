package com.haowaner.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理测试
 */
public class TestProxy {
    public static void main(String[] args) {
        Target target = new Target();
        Advice advice = new Advice();
        //cglib方式实现动态代理
         //增强器
        Enhancer enhancer = new Enhancer();
        //获取目标类
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //具体增强
                advice.before();
                Object invoke = method.invoke(target, args);
                advice.after();
                return invoke;
            }
        });
        Target ct = (Target) enhancer.create();
        ct.save();
    }
}
