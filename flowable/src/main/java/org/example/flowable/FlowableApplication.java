package org.example.flowable;

import org.flowable.engine.ManagementService;
import org.flowable.engine.impl.db.ProcessDbSchemaManager;
import org.flowable.job.service.impl.asyncexecutor.AsyncExecutor;
import org.flowable.job.service.impl.asyncexecutor.DefaultJobManager;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FlowableApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(FlowableApplication.class, args);

        FlowableService bean =(FlowableService) run.getBean("flowableService");
        MyJavaDelegate bean1 =(MyJavaDelegate) run.getBean("myJavaDelegate");
        System.out.println("bean1: " + bean1);
//
//        bean.deployProcessDefinition();
        bean.startProcess( "intermediateTimerExample");
//ProcessEnginePostEngineBuildConsumer；
//        SpringProcessEngineConfiguration

//        DefaultJobManager
//        ManagementService
//        ProcessDbSchemaManager
//
//        bean.suspendProcess();

//        bean.suspendProcess();

//        bean.activateProcess();

//        bean.completeTask( "100004");

//        AsyncExecutor；
    }

}
