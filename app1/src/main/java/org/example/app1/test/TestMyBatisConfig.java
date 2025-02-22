//package org.example.app1.test;
//
//@TestConfiguration
//@MapperScan("com.msxf.icc2.tenant.service.mapper") // 确保扫描到您的Mapper接口
//public class TestMyBatisConfig {
//
//    @Bean
//    public DataSource dataSource() {
//        return DataSourceBuilder.create()
//                .driverClassName("org.h2.Driver")
//                .url("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE")
//                .username("sa")
//                .password("")
//                .build();
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        // 如果使用XML映射文件，需要设置mapperLocations属性
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/**/*.xml"));
//        return sessionFactory.getObject();
//    }
//}