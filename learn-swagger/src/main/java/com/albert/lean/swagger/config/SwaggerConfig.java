package com.albert.lean.swagger.config;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * @author Albert
 */
@Configuration
public class SwaggerConfig {

    @Value("${swagger.token}")
    private String HEADER;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo())
                .securitySchemes(Collections.singletonList(new ApiKey(HEADER, HEADER, SecurityScheme.In.HEADER.name())))
                .securityContexts(Collections.singletonList(SecurityContext.builder()
                        .securityReferences(Collections.singletonList(SecurityReference.builder()
                                .scopes(new AuthorizationScope[0]).reference(HEADER).build()))
                        .operationSelector(o -> o.requestMappingPattern().matches("/.*")).build()))
                .select()
                //apis： 添加swagger接口提取范围
                .apis(RequestHandlerSelectors.basePackage("com.albert.lean.swagger.controller"))
                .paths(PathSelectors.any()).build();
    }

    //swagger-ui/index.html
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Swagger3接口文档").description("更多请咨询服务开发者Ray")
                //.contact(new Contact("Ray", "", ""))
                .version("1.0").build();
    }
}
