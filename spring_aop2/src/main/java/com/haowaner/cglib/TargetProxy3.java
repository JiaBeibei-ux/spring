package com.haowaner.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用cglib第三方使用动态代理
 */
public class TargetProxy3 {
    public static void main(String[] args) {
        //目标类
       final Target target = new Target();
        Advice advice = new Advice();
        //Enhancer
        //Class  字节码文件
        //callback
        Enhancer enhancer = new Enhancer();
        //设置父类 目标类
        enhancer.setSuperclass(target.getClass());
        //增强
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * 和jdk动态代理方式几乎一样
             * @param proxy
             * @param method
             * @param args
             * @param methodProxy
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
        Target cglibTarget = (Target) enhancer.create();
        cglibTarget.save();
    }
}
