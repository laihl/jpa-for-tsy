package com.hailong.jpafortsy.config;

import com.hailong.jpafortsy.interceptor.DefaultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class DefaultIntercepctorConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DefaultInterceptor()).addPathPatterns("/*");
        super.addInterceptors(registry);
    }
}
