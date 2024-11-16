package org.example.feign;

import org.example.cloudloadbalancer.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserServiceClient userServiceClient;

    public User doSomething(Long userId) {

        User user = userServiceClient.getUserById(userId);
        // 可以在这里对获取到的用户信息进行进一步处理
        return user;
    }


    public void createOrderAndRegisterUser() {
        User newUser = new User();
        // 设置用户信息，如用户名、密码等

        newUser.setName("name-----");

        String result = userServiceClient.registerUser(newUser);
        System.out.println("用户注册结果：" + result);
    }
}