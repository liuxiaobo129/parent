package org.example.swagger;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot Swagger Example API")
                        .version("1.0.0")
                        .description("This is a sample Spring Boot RESTful service using Swagger/OpenAPI"));
    }
}