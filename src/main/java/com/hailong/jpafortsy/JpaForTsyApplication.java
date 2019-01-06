package com.hailong.jpafortsy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class JpaForTsyApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JpaForTsyApplication.class, args);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
//            log.info(name);
        }
/**
 * redis default demo
 */
//        StringRedisTemplate redisTemplate = context.getBean(StringRedisTemplate.class);
//        redisTemplate.opsForValue().set("name","hailong",1000*10);
//

    }

}
