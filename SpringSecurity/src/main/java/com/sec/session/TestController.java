package com.sec.session;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "这是公共接口，任何人都可以访问";
    }

    @GetMapping("/secure")
    public String secureEndpoint() {
        return "这是受保护的接口，必须登录后才能访问";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "这是admin的接口，必须登录后才能访问";
    }

    @GetMapping("/user")
    public String userEndpoint() {
        return "这是user的接口，必须登录后才能访问";
    }
}
