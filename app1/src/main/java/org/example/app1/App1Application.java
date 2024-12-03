package org.example.app1;

import ch.qos.logback.classic.PatternLayout;
import org.example.app1.annotationqualifier.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App1Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(CoreConfig.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App1Application.class, args);

//        ValidationService validationService = (ValidationService)run.getBean("validationService");
//
//        validationService.getValidators();
        LOGGER.info("Initializing flowable-cdi.");

//        PatternLayout ；


    }

}
