package org.example.dubb;

import org.apache.dubbo.config.ServiceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProviderConfiguration {
    @Bean
    public ServiceConfig demoService() {
        ServiceConfig service = new ServiceConfig();
//        service.setRegistry();
        return service;
    }
}