package org.example.zookeeperserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Zookeeper Provider!";
    }
}