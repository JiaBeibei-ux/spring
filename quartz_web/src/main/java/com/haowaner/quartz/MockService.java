package com.haowaner.quartz;

import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class MockService {
    public void mockMothed() {
        System.out.println("执行l。。。。。。" + new Date().getTime());
    }
}
