package org.example.dubbservice;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.spring.ReferenceBean;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@DubboService(registry="zk-registry")
public class DemoServiceImpl implements DemoService {

    static {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Task executed at: " + System.currentTimeMillis());

        // 定时任务，延迟2秒后每3秒执行一次
        scheduler.scheduleAtFixedRate(task, 2, 3, TimeUnit.SECONDS);
    }

    @Override
    public String hello(String name) {
        ReferenceBean referenceBean = new ReferenceBean();
        System.out.println("hello " + name);
        return name;
    }
}


