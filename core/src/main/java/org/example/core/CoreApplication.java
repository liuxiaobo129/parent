package org.example.core;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.config.AopConfigUtils;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CoreApplication.class, args);

        MyService myService = (MyService)run.getBean("myService");
        myService.sayHello();

//        ConfigurationClassPostProcessor;

//        AbstractAutoProxyCreator

//        AnnotationAwareAspectJAutoProxyCreator

//        InfrastructureAdvisorAutoProxyCreator

//        org.springframework.transaction.config.internalTransactionAdvisor

//        AopConfigUtils
    }

}
