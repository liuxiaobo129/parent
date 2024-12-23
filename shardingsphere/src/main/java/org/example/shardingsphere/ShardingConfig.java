package org.example.shardingsphere;


import lombok.RequiredArgsConstructor;
import org.apache.shardingsphere.shardingjdbc.spring.boot.sharding.SpringBootShardingRuleConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
@EnableConfigurationProperties(AppConfig.class)
//@RequiredArgsConstructor
public class ShardingConfig {

    private final AppConfig appConfig;

    private final Environment environment;

    public ShardingConfig(AppConfig appConfig, Environment environment) {
        this.appConfig = appConfig;
        this.environment = environment;
    }


    @Bean
    public void printAppDetails() {
//        System.out.println("App Name: " + appConfig.getName());

        System.out.println(appConfig.getInfo().getTableName());
        System.out.println(environment);

    }


}