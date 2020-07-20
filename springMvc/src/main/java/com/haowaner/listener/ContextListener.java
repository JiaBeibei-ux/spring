package com.haowaner.listener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContextListener全局监听器
 */
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        //拿到applicationContext.xml
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(contextConfigLocation);
        servletContext.setAttribute("app",context);
        System.out.println("spring容器创建了。。。。");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
