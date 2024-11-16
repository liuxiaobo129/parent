package org.example.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import java.util.Arrays;
import java.util.List;

@Component
public class RequestTimeGatewayFilterFactory extends AbstractGatewayFilterFactory<RequestTimeGatewayFilterFactory.Config> {

    public RequestTimeGatewayFilterFactory() {
        super(RequestTimeGatewayFilterFactory.Config.class);
    }

    @Override
    public GatewayFilter apply(RequestTimeGatewayFilterFactory.Config config) {
        return (exchange, chain) -> {
            exchange.getAttributes().put("startTime", System.currentTimeMillis());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                Long startTime = exchange.getAttribute("startTime");
                if (startTime!= null) {
                    System.out.println("请求处理时间：" + (System.currentTimeMillis() - startTime) + "ms");
                }
            }));
        };
    }

    public static class Config {
        // 可以在这里定义过滤器需要的参数
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList();
    }
}