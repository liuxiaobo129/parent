package org.example.dubb;

import org.apache.dubbo.common.serialize.hessian2.Hessian2Serialization;
import org.apache.dubbo.config.spring.beans.factory.annotation.ReferenceAnnotationBeanPostProcessor;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.config.spring.schema.DubboBeanDefinitionParser;
import org.apache.dubbo.configcenter.support.zookeeper.ZookeeperDynamicConfiguration;
import org.apache.dubbo.registry.client.ServiceDiscoveryRegistryDirectory;
import org.apache.dubbo.registry.client.migration.MigrationInvoker;
import org.apache.dubbo.registry.integration.RegistryProtocol;
import org.apache.dubbo.rpc.cluster.loadbalance.RandomLoadBalance;
import org.apache.dubbo.rpc.protocol.dubbo.DubboProtocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDubbo
public class DubbApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DubbApplication.class, args);

        DemoClient demoService = (DemoClient)run.getBean("demoClient");



        System.out.println( demoService.sayHello("dubbo"));

//        DubboProtocol dubboProtocol = (DubboProtocol)run.getBean("dubboProtocol");

        MigrationInvoker migrationInvoker;

//        RegistryProtocol ；
//
//        ServiceDiscoveryRegistryDirectory r；


//        referenceBeanManager.addReference(this);

//        ReferenceAnnotationBeanPostProcessor

//        DubboBeanDefinitionParser  dubboBeanDefinitionParser;

//        RandomLoadBalance randomLoadBalance = new RandomLoadBalance();

//        ZookeeperDynamicConfiguration zookeeperDynamicConfiguration = new ZookeeperDynamicConfiguration();

        Hessian2Serialization serialization = new Hessian2Serialization();
    }

}
