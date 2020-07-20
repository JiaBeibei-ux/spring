package com.haowaner.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 配置类
 */
@Configuration//标注该类是一个标志类
@ComponentScan("com.haowaner")//扫描包
@Import(value = DataConfiguration.class)//导入其他配置类或文件
public class SystemConfiguration {
      //这里就引用了一个数据源
}
