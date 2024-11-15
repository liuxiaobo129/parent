package org.example.app1.annotationqualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OrderValidatorconfig {

    @Bean
//    @LoadBalanced
    @Qualifier
    public Validator orderValidator() {
        return new OrderValidator();
    }

}
