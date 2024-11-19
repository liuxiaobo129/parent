package org.example.rabbitmq;

import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfig {

    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Bean
    public RabbitAdmin rabbitAdmin() {
        return new RabbitAdmin(connectionFactory);
    }

    @Autowired
    private RabbitAdmin rabbitAdmin;

//    // 声明交换器的方法
//    public void declareDirectExchange() {
//        Queue queue = new Queue("your_queue_name");
//        rabbitAdmin.declareQueue(queue);
//        rabbitAdmin.declareExchange(new DirectExchange("my_direct_exchange"));
//    }

    public void bindQueueToExchange() {
        Queue queue = new Queue("your_queue_name");
        DirectExchange exchange = new DirectExchange("my_direct_exchange");
        Binding binding = BindingBuilder.bind(queue).to(exchange).with("your_binding_key");
        rabbitAdmin.declareBinding(binding);
    }

    @PostConstruct
    public void init() {
        bindQueueToExchange();
//        declareDirectExchange();
    }
}