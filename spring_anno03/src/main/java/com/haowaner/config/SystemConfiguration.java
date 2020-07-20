package com.haowaner.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 使用注解类
 */
@Configuration
@ComponentScan("com.haowaner")
@EnableAspectJAutoProxy
public class SystemConfiguration {
}
