package org.example.zookeeper;

import org.apache.zookeeper.client.ZKClientConfig;
import org.apache.zookeeper.server.ZooKeeperServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.zookeeper.discovery.ZookeeperServiceInstance;
import org.springframework.cloud.zookeeper.serviceregistry.ZookeeperServiceRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ZookeeperServiceRegistry zookeeperServiceRegistry;

    @GetMapping("/invoke")
    public String invokeProvider() {
        ZKClientConfig config = new ZKClientConfig();

        ZooKeeperServer zkServer = new ZooKeeperServer();


        // 调用服务提供者
        String response = restTemplate.getForObject("http://zookeeper-demo/provider/hello", String.class);
        return "Response from Provider: " + response;
//        ZookeeperServiceInstance
    }
}
