package org.example.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Random;

@Component
public class ServiceCaller {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    public List<ServiceInstance> getTargetServiceInstances(String serviceName) {
        return discoveryClient.getInstances(serviceName);
    }

    public String callTargetService(String serviceName) {
        List<ServiceInstance> serviceInstances = getTargetServiceInstances(serviceName);
        if (serviceInstances.isEmpty()) {
            return "No service instances available.";
        }

        // 随机选择一个实例
        Random random = new Random();
        int index = random.nextInt(serviceInstances.size());
        ServiceInstance selectedInstance = serviceInstances.get(index);

        // 解析实例信息获取主机和端口

        String host = selectedInstance.getHost();
        int port = selectedInstance.getPort();

        // 构建请求URL
        String url = "http://" + host + ":" + port + "/your-service-endpoint";

        // 发送请求
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}