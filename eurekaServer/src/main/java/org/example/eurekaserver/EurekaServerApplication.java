package org.example.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

	public static void main(String[] args) {
		System.setProperty("EUREKA_SERVER_PORT","8306");
		SpringApplication.run(EurekaServerApplication.class, args);
		System.out.println("Eureka Server Started");
	}

}
