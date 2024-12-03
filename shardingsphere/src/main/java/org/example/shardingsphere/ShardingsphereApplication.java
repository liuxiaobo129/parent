package org.example.shardingsphere;

import org.example.shardingsphere.mapper.OrderMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class ShardingsphereApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ShardingsphereApplication.class, args);
        OrderMapper orderService = (OrderMapper)run.getBean("orderMapper");

//        System.out.println(orderService);
//
//        Order order1 = new Order();
//        order1.setOrderId(1L);
//        order1.setUserId(1L);
//        order1.setStatus("NEW");
//
//        Order order2 = new Order();
//        order2.setOrderId(2L);
//        order2.setUserId(2L);
//        order2.setStatus("PENDING");
//
//        orderService.insertOrder(order1);
//        orderService.insertOrder(order2);

        List<Order> order = orderService.selectOrderById(1L);

        System.out.println(order);


    }

}
