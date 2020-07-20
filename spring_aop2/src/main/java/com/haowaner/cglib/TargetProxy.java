package com.haowaner.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 目标代理 就是具体的增强
 * cglib方式 目标类不能是finalClass
 * 基于子类的动态代理
 */
public class TargetProxy {
    public static void main(String[] args) {
        Target target = new Target();
        Advice advice = new Advice();
        //如何增强 使用ENhancer  通过反射实现
        // Class 目标字节码
        //callbacck :用于提供增强的代码 MetnodInterceptor
        Target cglibTarget = (Target) Enhancer.create(target.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会执行该方法
             * @param proxy
             * @param method
             * @param args
             * 以上三个参数和Jdk基于接口的动态代理中的invoke方法中的参数一样
             * @param methodProxy 当前执行方法的代理对象 更用不上了
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                advice.after();
                Object invoke = method.invoke(target,args);//invoke(对象，参数)
                advice.before();
                return invoke;
            }
        });
        cglibTarget.save();
    }
}
