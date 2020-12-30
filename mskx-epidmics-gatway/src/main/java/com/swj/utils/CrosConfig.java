package com.swj.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrosConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
        /**
         * 所有请求都允许跨域，使用这种配置就不需要
         * 在interceptor中配置header了
         */
        registry.addMapping("/**")
                .allowedHeaders("Access-Control-Allow-Origin", "*")
                .allowedHeaders("Access-Control-Allow-Headers", "*")
                .allowedHeaders("Access-Control-Allow-Methods", "*")
                .allowCredentials(true)
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("*")
                .maxAge(3600);
    }

//    @Bean
//    public CorsWebFilter corsWebFilter(){
//        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
//        CorsConfiguration corsConfiguration=new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedMethod("*");
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.setAllowCredentials(true);
//        source.registerCorsConfiguration("/**",corsConfiguration);
//        return new CorsWebFilter((CorsConfigurationSource) source);
//    }


}
