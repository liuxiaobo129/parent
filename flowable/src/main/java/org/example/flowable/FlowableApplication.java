package org.example.flowable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FlowableApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(FlowableApplication.class, args);

        FlowableService bean =(FlowableService) run.getBean("flowableService");
//
        bean.deployProcessDefinition();
//
//        bean.startProcess();
//
//        bean.suspendProcess();

//        bean.suspendProcess();

//        bean.activateProcess();

//        bean.completeTask( "207501");
    }

}
