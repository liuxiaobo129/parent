package org.example.cloudloadbalancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CloudloadbalancerApplication {

	public static void main(String[] args) throws InterruptedException {

		ConfigurableApplicationContext run = SpringApplication.run(CloudloadbalancerApplication.class, args);

//		LoadBalancerClient


	}

}
