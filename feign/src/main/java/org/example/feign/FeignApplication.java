package org.example.feign;

import org.example.cloudloadbalancer.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableFeignClients
public class FeignApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(FeignApplication.class, args);

        UserService userService = (UserService)run.getBean("userService");

//        User user = userService.doSomething(1L);
        userService.createOrderAndRegisterUser();

//        System.out.println(user.getName());

    }

}
