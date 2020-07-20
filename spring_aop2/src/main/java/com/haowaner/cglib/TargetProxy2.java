package com.haowaner.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用cglib第三方使用动态代理
 */
public class TargetProxy2 {
    public static void main(String[] args) {
        //目标类
       final Target target = new Target();
        Advice advice = new Advice();
        //Enhancer
        //Class  字节码文件
        //callback
        Target cglibTarget = (Target) Enhancer.create(
                target.getClass(),
                //具体的增强的方法
                new MethodInterceptor() {
                    /**
                     *
                     * @param proxy   目标对象代理实例
                     * @param method  目标对象中的方法
                     * @param args    目标对象中的方法
                     * @param methodProxy 现在更用不到了
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
                }
        );
        cglibTarget.save();
    }
}
