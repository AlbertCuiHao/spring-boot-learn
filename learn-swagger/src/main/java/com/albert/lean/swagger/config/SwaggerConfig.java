package com.albert.lean.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Albert
 */
@Configuration
public class SwaggerConfig {

    @Value("${albert.swagger.token_header}")
    private String TOKEN_HEADER;
    @Value("${albert.swagger.base_package}")
    private String BASE_PACKAGE;

    @Bean
    public OpenAPI createOpenAPI() {
        return new OpenAPI().info(apiInfo());
    }

    //swagger-ui/index.html
    public Info apiInfo() {
        return new Info()
                .title("SpringDoc API Test")
                .description("SpringDoc Simple Application Test")
                .version("0.0.1");
    }
}
