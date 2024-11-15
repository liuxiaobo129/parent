package org.example.app1.annotationqualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
//@AutoConfiguration
//@ConditionalOnBean(Validator.class)
@AutoConfigureBefore(Validator.class)
public class ValidatorConfig {

//    @LoadBalanced
    @Qualifier
    @Autowired(required = false)
    private List<Validator> validators  = Collections.emptyList();;


    @Bean
    public Validator userValidator() {
        validators.add(null);
        return new OrderValidator();
    }
}




//class UserValidator implements Validator{}