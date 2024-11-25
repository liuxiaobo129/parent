package org.example.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RabbitmqApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(RabbitmqApplication.class, args);

        RabbitMQProducer rabbitMQProducer = (RabbitMQProducer)run.getBean("rabbitMQProducer");

        rabbitMQProducer.sendMessage("my_direct_exchange","your_binding_key","aaaa");

        System.out.println("test!!!!");


    }

}
