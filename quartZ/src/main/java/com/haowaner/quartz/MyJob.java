package com.haowaner.quartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 *job 任务
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //创建工作详情
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        //获取工作的名字
        String name = jobDetail.getKey().getName();
        String group = jobDetail.getKey().getGroup();
        String data = jobDetail.getJobDataMap().getString("data04");
        System.out.println("job执行，job名："+name+" group"+"data"+data+new Date());
    }
}
