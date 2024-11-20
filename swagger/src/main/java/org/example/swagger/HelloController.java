package org.example.swagger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {




    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Swagger!";
    }
}