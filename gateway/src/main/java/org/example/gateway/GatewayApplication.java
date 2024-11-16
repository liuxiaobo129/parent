package org.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        System.setProperty("io.netty.resolver.dns.native.disabled", "true");
        SpringApplication.run(GatewayApplication.class, args);
    }

}
