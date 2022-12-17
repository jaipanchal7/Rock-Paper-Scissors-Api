package com.rock_paper_scissor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerConfiguration(){
        // return a prepared Docket instance
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//				.paths(PathSelectors.ant("/*"))
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.rock_paper_scissor"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Rock Paper Scissors Api",
                "Sample API for Assignment",
                "1.0",
                "Free to use",

                new springfox.documentation.service.Contact("Jai Panchal","https://swagger.io/tools/swagger-ui/","jaipanchal100@gmail.com"),

                "API License",
                "https://swagger.io/tools/swagger-ui/",
                Collections.emptyList()
        );
    }
    // for swagger api doc generation
    // http://localhost:8080/v2/api-docs

    // for swagger api ui generation
    // http://localhost:8080/swagger-ui/index.html
}