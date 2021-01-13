package com.swj.Util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30).pathMapping("/")
                .enable(true) // 是否开启swagger配置，生产环境需关闭
                .apiInfo(this.apiInfo())
                .select() // 指定需要发布到Swagger的接口目录，不支持通配符
                .apis(RequestHandlerSelectors.basePackage("com.swj.controller"))
                .paths(PathSelectors.any())
                .build()
                .protocols(this.newHashSet("https", "http"));  // 支持的通讯协议集合
    }

    /**
     * 项目信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Swagger Api Doc")
                .description("SpringBoot后台接口")
                .contact(new Contact("冥思苦想项目", null, ""))
                .version("Application Version: 1.0.0")
                .build();
    }

    @SafeVarargs
    private final <T> Set<T> newHashSet(T... ts) {
        if (ts.length > 0) {
            return new LinkedHashSet<>(Arrays.asList(ts));
        }
        return null;
    }
}