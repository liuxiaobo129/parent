package org.example.cloudloadbalancer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Long id) {
        // 这里可以根据id从数据库或者其他数据源获取用户信息
        User user = new User();
        user.setId(id);
        user.setName("Example User");
        return user;
    }

}