package org.example.swagger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable("id") Long id) {
        // 这里可以根据id从数据库或者其他数据源获取用户信息

        return "test";
    }



    @GetMapping("/users2/{id}")
    public String getUser2(@PathVariable("id") Long id) {
        // 这里可以根据id从数据库或者其他数据源获取用户信息

        return "test2";
    }

}