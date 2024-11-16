package org.example.eurekaclient;

import org.example.eurekaclient.loabanler.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EurekaclientApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(EurekaclientApplication.class, args);

//        ServiceCaller serviceCaller = (ServiceCaller)run.getBean("serviceCaller");
//        serviceCaller.callTargetService("eurekaServer");
//        System.out.println(serviceCaller);

        Thread.sleep(3000);

        OrderService bean = (OrderService)run.getBean("orderService");

        bean.createOrder(1L);

        System.out.println("end !!!");

    }

}
