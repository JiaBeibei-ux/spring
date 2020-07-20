package com.haowaner.anno;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration//标识这是一个配置类
//<context:component-scan base-package="com.haowaner"></context:component-scan>
@ComponentScan("com.haowaner")
//<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
@EnableAspectJAutoProxy
public class SystemConfiguration {

}
