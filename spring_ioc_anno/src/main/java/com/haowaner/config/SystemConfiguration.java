package com.haowaner.config;

import org.springframework.context.annotation.*;

/**
 * 系统配置类 作用代替xml
 */
@Configuration//表示该类是一个配置类
//<context:component-scan base-package="com.haowaner"></context:component-scan>
@ComponentScan("com.haowaner")//包扫描
@Import(DataConfiguration.class)
public class SystemConfiguration {


}
