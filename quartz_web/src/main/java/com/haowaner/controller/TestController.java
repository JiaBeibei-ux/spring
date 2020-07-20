package com.haowaner.controller;

import org.quartz.JobBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quartz")
public class TestController {

    //添加一个定时任务 jt=新任务的相关数据
    /*@RequestMapping("/add")
    public String addJob(JobAndTrigger jt){
        JobBuilder.newJob()Class.forName(jt.)
    }*/
}
