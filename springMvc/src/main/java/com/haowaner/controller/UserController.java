package com.haowaner.controller;

import com.haowaner.service.impl.UserServiceImpl;
import com.haowaner.utils.WebContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 模拟controller
 */
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //加载配置文件   在这里加载配置文件比较繁琐  移到web.xml
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ServletContext servletContext = req.getSession().getServletContext();
        //ApplicationContext context = (ApplicationContext) servletContext.getAttribute("app");
        ApplicationContext context = WebContext.getContext(servletContext);
        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        userService.save();
    }
}
