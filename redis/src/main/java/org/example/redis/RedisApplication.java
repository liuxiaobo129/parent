package org.example.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(RedisApplication.class, args);

        RedisService redisService = (RedisService)run.getBean("redisService");

        UserService userService = (UserService)run.getBean("userService");
//
//        redisService.setValue("aa1","1111");
//
//        System.out.println(redisService.getValue("aa"));
//
//        Map<String, String> hash = new HashMap<>();
//
//        hash.put("field1", "value1");
//        hash.put("field2", "value2");
//
//        redisService.insertHash("myHashKey3", hash);

        User user = new User();
        user.setAge(30);
        user.setName("lxb");
        user.setId("1");
        userService.saveUser(user);
    }

}
