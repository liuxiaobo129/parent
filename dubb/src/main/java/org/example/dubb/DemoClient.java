package org.example.dubb;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.dubbservice.DemoService;
import org.springframework.stereotype.Component;


@Component
public class DemoClient {

    @DubboReference
    private DemoService demoService;


    public String sayHello(String name) {
        return demoService.hello(name);
    }
}