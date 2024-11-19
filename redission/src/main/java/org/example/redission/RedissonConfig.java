package org.example.redission;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        // 配置Redisson，例如使用单节点服务器
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        // 如果设置了密码，则添加密码
        // config.useSingleServer().setPassword("yourpassword").setAddress("redis://127.0.0.1:6379");
        return Redisson.create(config);
    }
}