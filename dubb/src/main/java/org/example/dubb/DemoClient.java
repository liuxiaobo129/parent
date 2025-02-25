package org.example.dubb;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.cluster.loadbalance.RandomLoadBalance;
import org.example.dubbservice.DemoService;
import org.springframework.stereotype.Component;


@Component
public class DemoClient {

    @DubboReference(loadbalance = "random")
    private DemoService demoService;


    public String sayHello(String name) {
        return demoService.hello(name);
    }

    public static void main(String[] args) {
        final DemoClient demoClient = new DemoClient();
    }
}