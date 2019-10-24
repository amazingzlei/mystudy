package com.fh.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TaskService {

    @Scheduled(cron = "0/2 * * * * ? ")
    public void testScheduled(){
        System.out.println("定时任务..............");
    }
}
