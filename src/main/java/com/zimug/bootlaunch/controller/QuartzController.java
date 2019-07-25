package com.zimug.bootlaunch.controller;

import com.zimug.bootlaunch.timertask.dynamic.QuartzBean;
import com.zimug.bootlaunch.timertask.dynamic.QuartzUtils;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/quartz/job/")
public class QuartzController {
    //注入任务调度
    @Resource
    private Scheduler scheduler;

    @PostMapping("/create")
    @ResponseBody
    public String createJob(@RequestBody QuartzBean quartzBean) throws SchedulerException, ClassNotFoundException {
        QuartzUtils.createScheduleJob(scheduler,quartzBean);
        return "已创建任务";//这里return不是生产级别代码，测试简单写一下
    }

    @PostMapping("/pause")
    @ResponseBody
    public String pauseJob(String jobName) throws SchedulerException {
        QuartzUtils.pauseScheduleJob (scheduler,jobName);
        return "已暂停成功";//这里return不是生产级别代码，测试简单写一下
    }

    @PostMapping("/run")
    @ResponseBody
    public String runOnce(String jobName) throws SchedulerException {
        QuartzUtils.runOnce (scheduler,jobName);
        return "运行任务" + jobName + "成功";//这里return不是生产级别代码，测试简单写一下
    }

    @PostMapping("/resume")
    @ResponseBody
    public String resume(String jobName) throws SchedulerException {
        QuartzUtils.resumeScheduleJob(scheduler,jobName);
        return "恢复定时任务成功：" + jobName;
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(@RequestBody QuartzBean quartzBean) throws SchedulerException {
        QuartzUtils.updateScheduleJob(scheduler,quartzBean);
        return "更新定时任务调度信息成功";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String update(String jobName) throws SchedulerException {
        QuartzUtils.deleteScheduleJob(scheduler,jobName);
        return "删除定时任务调度信息成功";
    }
}

