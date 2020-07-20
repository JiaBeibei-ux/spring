package com.haowaner.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Handler;

/**
 * 目标代理 就是具体的增强
 */
public class TargetProxy {
    public static void main(String[] args) {
        Target target = new Target();
        Advice advice = new Advice();
        //如何增强 使用Proxy代理  通过反射实现
        // ClassLoader loader目标类加载器
        //class<?>[] interfaces目标接口
        // InvocationHandler h处理增强方法
        //targetInterface这是创建的具体的代理对象 已经对目标类进行了增强了
        TargetInterface targetInterface=(TargetInterface) Proxy.newProxyInstance(
                Target.class.getClassLoader(),
                Target.class.getInterfaces(),
                new InvocationHandler() {
                    /**
                     *
                     * @param proxy 代理 目前没有用到
                     * @param method 具体增强的方法
                     * @param args 方法中的参数
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.after();
                        Object invoke = method.invoke(target,args);//invoke(对象，参数)
                        advice.before();
                        return invoke;
                    }
                }
        );
        targetInterface.save();
    }
}
