package com.haowaner.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * 功能描述
 */
public class MyJob{
    @Autowired
    private MockService mockService;

    public void mockCallService(){
        mockService.mockMothed();
    }
}
