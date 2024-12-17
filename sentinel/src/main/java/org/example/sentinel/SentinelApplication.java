package org.example.sentinel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication.class, args);
    }


//    @Bean
//    public CommandLineRunner commandLineRunner(SentinelRuleConfig sentinelRuleConfig) {
//        return args -> {
//            // 初始化限流规则
//            sentinelRuleConfig.initFlowRules();
//        };
//    }

}
