package com.haowaner.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 增强类 用来增强具体的方法
 * 切面类
 *<bean id="aspectAdvice" class="com.haowaner.aop.Advice"></bean>
 */
@Component("advice")
@Aspect//这是一个切面类
public class Advice {
    //声明一个公共的切入点
    @Pointcut("execution(* com.haowaner.aop..*.*(..))")
    public void myPointcut(){

    }
    //前值增强
    @Before("myPointcut()")
    public void before(){
        System.out.println("前值增强");
    }
    //前值增强
    @After("myPointcut()")
    public void after() {
        System.out.println("后置增强");
    }


    //<aop:pointcut id="myPointcut" expression="execution(* com.haowaner.aop..*.*())"/>
    //环绕通知
    /*@Around("myPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("前置。。。。");
        Object proceed = joinPoint.proceed();
        System.out.println("后置。。。。");
        return  proceed;
    }*/
}
