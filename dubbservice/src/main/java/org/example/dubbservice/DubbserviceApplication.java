package org.example.dubbservice;


import org.apache.dubbo.config.deploy.DefaultApplicationDeployer;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.metrics.filter.MetricsFilter;
import org.apache.dubbo.metrics.prometheus.PrometheusMetricsReporterFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DubbserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubbserviceApplication.class, args);
//        DefaultApplicationDeployer deployer = new DefaultApplicationDeployer();

//        PrometheusMetricsReporterFactory metricsReporterFactory = new PrometheusMetricsReporterFactory();

//        MeterRegistry

//        BasicAuthHttpConnectionFactory authHttpConnectionFactory;

//        MetricsFilter metricsFilter = new MetricsFilter();
    }

}
