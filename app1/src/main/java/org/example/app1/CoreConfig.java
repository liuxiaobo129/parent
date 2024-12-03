package org.example.app1;

import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DatabaseConfig.class) // 导入DatabaseConfig，确保dataSource加载到容器中
public class CoreConfig {

    LoggingApplicationListener applicationListener;
}