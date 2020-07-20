package com.haowaner.controller;

import com.haowaner.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController2 {
    @RequestMapping("/show")
    public ModelAndView show(ModelAndView model){
        System.out.println("show.....");
        model.addObject("name","Jack");
        model.setViewName("success");
        return model;
    }
    @RequestMapping("/index")
    public void test() throws Exception{
        System.out.println("test.....");
        //异常处理
        try {
            int i=12/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("xxx异常,请检查你输入的数据！");
        }
    }
    @RequestMapping("/index2")
    public void test2() throws Exception{
        System.out.println("test.....rerfa");
        //异常处理
            int i=12/0;
    }
}
