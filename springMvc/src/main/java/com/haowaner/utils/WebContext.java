package com.haowaner.utils;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

public class WebContext {
    //代替这句话ApplicationContext context = (ApplicationContext) servletContext.getAttribute("app");
    public static ApplicationContext  getContext(ServletContext servletContext){
        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
