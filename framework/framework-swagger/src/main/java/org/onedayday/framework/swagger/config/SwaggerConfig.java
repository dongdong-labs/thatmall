package org.onedayday.framework.swagger.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {

    @Value("${settings.swagger.enable:true}")
    private boolean enableSwagger;

    @Value("${settings.swagger.basepackage:org.onedayday}")
    private String basePackage;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enableSwagger)
                .apiInfo(apiInfo())  
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/");
    }  
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("接口")
                .description("接口文档")
                .version("1.0")
                .build();  
        return apiInfo;  
    }  
} 