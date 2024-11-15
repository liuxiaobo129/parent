package org.example.app1;

import org.example.app1.annotationqualifier.ValidationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App1Application.class, args);

//        ValidationService validationService = (ValidationService)run.getBean("validationService");
//
//        validationService.getValidators();
    }

}
