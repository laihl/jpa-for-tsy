package com.hailong.jpafortsy;


import jodd.http.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMap;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import javax.sql.DataSource;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
@Slf4j
public class JpaForTsyApplication {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = SpringApplication.run(JpaForTsyApplication.class, args);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            log.info(name);
        }
    }

}
