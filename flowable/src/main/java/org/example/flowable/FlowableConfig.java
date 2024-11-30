package org.example.flowable;

import org.flowable.engine.ProcessEngine;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;
import org.flowable.engine.TaskService;
@Configuration
public class FlowableConfig {

    // 配置数据源
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/flowable_db?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("LXBrcs123!");
        return dataSource;
    }

    // 配置事务管理器
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    // 配置 SpringProcessEngineConfiguration
    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration() {
        SpringProcessEngineConfiguration configuration = new SpringProcessEngineConfiguration();
        configuration.setDataSource(dataSource());  // 设置数据源
        configuration.setTransactionManager(transactionManager());  // 设置事务管理器
        configuration.setDatabaseSchemaUpdate("true");  // 自动更新数据库表结构
        return configuration;
    }

    // 创建 ProcessEngine Bean
    @Bean
    public ProcessEngine processEngine(SpringProcessEngineConfiguration springProcessEngineConfiguration) {
        return springProcessEngineConfiguration.buildProcessEngine();
    }

    // 创建 RepositoryService Bean
    @Bean
    public RepositoryService repositoryService(ProcessEngine processEngine) {
        return processEngine.getRepositoryService();
    }

    // 创建 RuntimeService Bean
    @Bean
    public RuntimeService runtimeService(ProcessEngine processEngine) {
        return processEngine.getRuntimeService();
    }


    @Bean
    public TaskService taskService(ProcessEngine processEngine) {
        return processEngine.getTaskService();
    }
}