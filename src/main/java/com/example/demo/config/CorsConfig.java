package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("http://127.0.0.1:8080", //vue는 허용하겠다는 소리, *로 써도 되지만 전부 다라는 이야기
                                "http://localhost:8080",
                                "http://192.168.20.3:8080",
                                "http://221.149.244.32:8080",
                                "http://get-moim.shop:8080"
                        )
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
