package com.hailong.jpafortsy;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;

@SpringBootApplication
@EnableSwagger2
@Slf4j
public class JpaForTsyApplication {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = SpringApplication.run(JpaForTsyApplication.class, args);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
//            log.info(name);
        }
    }

}
