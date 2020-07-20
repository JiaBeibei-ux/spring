package com.haowaner.test;

import com.haowaner.quartz.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.GregorianCalendar;

import static org.quartz.DateBuilder.MONDAY;
import static org.quartz.DateBuilder.TUESDAY;


public class QuartZTest {
    public static void main (String[] args) throws Exception{
        testSimpleTrigger2();
    }
    public static void testCalendarTrigger() throws Exception{
        //调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //触发器构建器
        //TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        //创建触发器 withRepeatCount(2)
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("T1", "G1")
                .startNow()//加入调度器 立即生效
                .withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule()
                .withIntervalInSeconds(2))
                //.endAt(new GregorianCalendar(2020,5,14,19,53,45).getTime())
                .build();
        //创建jobDetail
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job", "group4").usingJobData("data04", "Hello WOrld!")
                .build();
        //调度器吧  注册触发器和job做关联
        scheduler.scheduleJob(jobDetail,trigger);
        //启动 内部注册的处罚器开始计时
        scheduler.start();

        //关闭调度器
        Thread.sleep(50000);
        scheduler.shutdown();
    }
    public static void testSimpleTrigger() throws Exception{
        //调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //触发器构建器
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        //创建触发器 withRepeatCount(2)
        SimpleTrigger trigger = triggerBuilder.withIdentity("T1", "G1")
                .startNow()//加入调度器 立即生效
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(2).repeatForever())
                .endAt(new GregorianCalendar(2020,5,14,19,53,45).getTime())
                .build();
        //创建jobDetail
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job", "group4").usingJobData("data04", "Hello WOrld!")
                .build();
        //调度器吧  注册触发器和job做关联
        scheduler.scheduleJob(jobDetail,trigger);
        //启动 内部注册的处罚器开始计时
        scheduler.start();

        //关闭调度器
        Thread.sleep(50000);
        scheduler.shutdown();
    }
    public static void testSimpleTrigger2() throws Exception{
        //调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //触发器构建器
        //TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        //创建触发器 withRepeatCount(2)
        Trigger trigger =  TriggerBuilder.newTrigger().withIdentity("T1", "G1")
                .startNow()//加入调度器 立即生效
                .withSchedule(DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule()
                 .startingDailyAt(TimeOfDay.hourAndMinuteOfDay(9,0))
                  .endingDailyAt(TimeOfDay.hourAndMinuteOfDay(20,0))
                    .onDaysOfTheWeek(MONDAY,TUESDAY)
                .withIntervalInSeconds(1))
                        //.withRepeatCount()
                .build();
        //创建jobDetail 具体的工作
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job", "group4").usingJobData("data04", "Hello WOrld!")
                .build();
        //调度器吧  注册触发器和job做关联
        scheduler.scheduleJob(jobDetail,trigger);
        //启动 内部注册的处罚器开始计 时
        scheduler.start();

        //关闭调度器
        Thread.sleep(50000);
        scheduler.shutdown();
    }
    public static void test() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //testCalendarTrigger();
    }
}
