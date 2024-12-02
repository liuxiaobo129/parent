package org.example.flowable;

import org.flowable.engine.impl.db.ProcessDbSchemaManager;
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
//          bean.startProcess( "parallelExample");
//ProcessEnginePostEngineBuildConsumer；
//        SpringProcessEngineConfiguration


//        ProcessDbSchemaManager
//
//        bean.suspendProcess();

//        bean.suspendProcess();

//        bean.activateProcess();

        bean.completeTask( "82501");
    }

}
