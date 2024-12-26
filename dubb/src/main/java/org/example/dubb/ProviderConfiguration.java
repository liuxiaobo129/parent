package org.example.dubb;

import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.spring.context.DubboInfraBeanRegisterPostProcessor;
import org.apache.dubbo.registry.zookeeper.ZookeeperRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProviderConfiguration {
    @Bean
    public ServiceConfig demoService() {
        ServiceConfig service = new ServiceConfig();
//        service.setRegistry();
        return service;
//        ZookeeperRegistry registry = new ZookeeperRegistry();



//        DubboInfraBeanRegisterPostProcessor dubboInfraBeanRegisterPostProcessor = new DubboInfraBeanRegisterPostProcessor();
    }
}