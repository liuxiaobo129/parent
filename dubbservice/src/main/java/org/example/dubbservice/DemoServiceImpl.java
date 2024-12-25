package org.example.dubbservice;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.spring.ReferenceBean;

@DubboService(registry="zk-registry")
public class DemoServiceImpl implements DemoService {

    @Override
    public String hello(String name) {
        ReferenceBean referenceBean = new ReferenceBean();
        System.out.println("hello " + name);
        return name;
    }
}


