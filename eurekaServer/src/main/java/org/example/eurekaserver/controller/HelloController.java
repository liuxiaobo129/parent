package org.example.eurekaserver.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//将类声明为控制器
public class HelloController {
    @RequestMapping("/hello")//处理 "/hello" 路径的请求
    public String hello() {
        System.out.println("hello world");//它打印"hello world"到控制台
        return "Hello World";//返回字符串"Hello World"作为HTTP响应内容
    }
}
