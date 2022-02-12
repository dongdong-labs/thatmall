package org.onedayday.framework.swagger.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;




/**
 * @class: WebConfig
 * @description:
 * @author: wdd
 */
@Configuration
@EnableWebMvc
@Slf4j
@Order(1)
public class SwaggerWebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath*:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath*:/META-INF/resources/webjars/");
        log.info("swagger静态资源文件加载完成！");
    }

}
