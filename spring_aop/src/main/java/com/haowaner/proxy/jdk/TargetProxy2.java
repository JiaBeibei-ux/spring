package com.haowaner.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 目标代理
 */
public class TargetProxy2 {
    public static void main(String[] args) {
        Target target = new Target();
        Advice advice = new Advice();
        //如何对目标类进行增强 通过代理反射机制
        // ClassLoader loader, 目标类加载器
        //Class<?>[] interfaces, 目标类实现接口
        //InvocationHandler h 进行增强
        //InvocationHandler接口是proxy代理实例的调用处理程序实现的一个接口
        TargetInterface targetInterface = (TargetInterface) Proxy.newProxyInstance(
                Target.class.getClassLoader(),
                Target.class.getInterfaces(),
                new InvocationHandler(){
                    /**
                     *
                     * @param proxy 目标代理对象  目前没有用到
                     * @param method 目标对象中的方法
                     * @param args 目标对象中的方法的参数
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //进行增强
                        advice.before();
                        method.invoke(target,args);
                        advice.after();
                        return null;
                    }
                }
        );
        targetInterface.save();
    }
}
