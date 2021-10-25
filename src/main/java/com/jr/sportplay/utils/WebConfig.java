package com.jr.sportplay.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//全局配置类--配置跨域请求
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /**
         * 1.哪些是可以访问的资源
         * 2.跨域的来源
         * 3.允许跨域的方法
         * 4.是否允许携带信息
         * 5.最大响应时间
         */
        registry.addMapping("/**")
                .allowedOrigins("Http://localhost:8080","null")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
