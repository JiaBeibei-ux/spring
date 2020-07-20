package com.haowaner.quartZ2;

import org.quartz.*;

import java.util.Date;
@DisallowConcurrentExecution//不允许并发
public class MyJob implements Job
{
    //执行方法
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
       /* try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //创建工作
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        //获取工作的名称
        String name = jobDetail.getKey().getName();
        //获取工作所属的组
        String group = jobDetail.getKey().getGroup();
        String data04 = jobDetail.getJobDataMap().getString("data04");
        System.out.println("job执行，job名"+name+" ,group"+group+" ,data "+data04+" "+new Date());
    }
}
