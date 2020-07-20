package com.haowaner.domain;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 增强类 用来增强具体的方法
 */
@Component("advice")
@Aspect//标识这是一个切面类
public class Advice {
    @Pointcut("execution(* com.haowaner.domain..*.*(..))")
    public void myPointcut(){

    };
   /* //前值增强
    @Before("myPointcut()")
    public void before(){
        System.out.println("前值增强");
    }
    //前值增强
    @After("myPointcut()")
    public void after() {
        System.out.println("后置增强");
    }*/
    @Around("myPointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("前值增强....");
        Object proceed = joinPoint.proceed();
        System.out.println("前值增强....");
    }
}
