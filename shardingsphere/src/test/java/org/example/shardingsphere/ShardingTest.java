//package org.example.shardingsphere;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest
//public class ShardingTest {
//    @Autowired
//    private OrderService orderService;
//
//    @Test
//    public void testSharding() {
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
//        orderService.createOrder(order1);
//        orderService.createOrder(order2);
//
//        List<Order> orders = orderService.getOrders();
//        orders.forEach(System.out::println);
//    }
//}