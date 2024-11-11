package org.example.core;


import org.example.app1.CoreConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@Import(CoreConfig.class) // 显式引入 core 模块的配置
public class AppConfig {

    @Bean
    public MyService myService(DataSource dataSource) {
        return new MyService(dataSource); // 可以使用 core 模块中的 dataSource bean
    }
}