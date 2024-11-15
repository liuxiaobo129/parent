package org.example.eurekaclient.loabanler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.example.cloudloadbalancer.User;

@Service
public class OrderService {
    @Autowired
    private RestTemplate restTemplate;

    public Order createOrder(Long userId) {
        String userServiceUrl = "http://cloudloadbalancer/users/" + userId;
        User user = restTemplate.getForObject(userServiceUrl, User.class);
        // 基于获取到的用户信息创建订单的逻辑
        Order order = new Order();
        order.setUserId(userId);
        order.setUserName(user.getName());
//        BeanPostProcessor

        return order;
    }
}