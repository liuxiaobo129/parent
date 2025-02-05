package org.example.feign;

import org.example.cloudloadbalancer.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.cloud.openfeign.FeignClientFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserServiceClient userServiceClient;

    public User doSomething(Long userId) {

        User user = userServiceClient.getUserById(userId);
//        LoadBalancerClientFactory;
//        LoadBalancerClient

//        FeignClientFactory

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

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("AB");
        String result = mono.block();
        System.out.println(result); // 输出: Hello, Reactor!

        int x = 1;

        int y = 0;


        for (int i = 0; i < result.length(); i++) {
            Character character = result.charAt(0);
            if(character == 'A'){
                x = 2 * x + y;
            }else if(character == 'B'){
                y = 2 * y + x;
            }else {
                throw  new RuntimeException();
            }
        }
        System.out.println(x + y);
    }
}