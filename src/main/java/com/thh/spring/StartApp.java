package com.thh.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @SpringBootApplication :标注主程序，来表明这是一个springboot应用
 * @ImportResource(locations = {"classpath:bean.xml"}) 导入spring的配置文件，使其内容生效,但是springboot不推荐使用，推荐使用@Configuration
 */
@SpringBootApplication
//@ImportResource(locations = {"classpath:bean.xml"})
@EnableSwagger2
public class StartApp {

    public static void main(String[] args) {
        //启动springboot应用
        SpringApplication.run(StartApp.class,args);
    }
}
