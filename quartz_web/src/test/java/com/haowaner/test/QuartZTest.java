package com.haowaner.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.JobKey;
import org.quartz.TriggerKey;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class QuartZTest {
    @Autowired
    private StdScheduler stdScheduler;
    @Test
    public void test() throws Exception {
        System.out.println("hello World!");
        Thread.sleep(4000);
        /*//暂停触发器
        stdScheduler.pauseTrigger(TriggerKey.triggerKey("T1","G1_T1"));
        //解除
        stdScheduler.unscheduleJob(TriggerKey.triggerKey("T1","G1_T1"));
        //删除工作
        stdScheduler.deleteJob(JobKey.jobKey("job1","group1")); */
        //暂停和恢复
        /*stdScheduler.pauseJob(JobKey.jobKey("job1","group1"));

        Thread.sleep(5000);

        stdScheduler.resumeJob(JobKey.jobKey("job1","group1"));*/
        //暂停组内所有的job
        GroupMatcher<JobKey> groups = GroupMatcher.groupEquals("group1");
        stdScheduler.pauseJobs(groups);
        Thread.sleep(5000);
        stdScheduler.resumeJobs(groups);
        Thread.sleep(5000);
    }

}
