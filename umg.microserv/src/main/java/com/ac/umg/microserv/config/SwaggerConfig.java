package com.ac.umg.microserv.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Microservicio Productos API")
                .description("API REST para gestión de productos")
                .version("v1.0"));
    }
}
