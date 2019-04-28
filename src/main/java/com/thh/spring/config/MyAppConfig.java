package com.thh.spring.config;

import com.thh.spring.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置类.
 */
@Configuration
public class MyAppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public HelloService helloService() {
        return new HelloService();
    }

}
