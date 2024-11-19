package org.example.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
@RabbitListener(queues = "your_queue_name")
public class RabbitMQConsumer {
    @RabbitHandler
    public void handleMessage(String message) {
        System.out.println("Received message: " + message);
    }
}