package com.hailong.jpafortsy.config;

import com.hailong.jpafortsy.interceptor.ChareterSet;
import com.hailong.jpafortsy.interceptor.Default;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class DefaultSupportConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Default()).addPathPatterns("/*").addPathPatterns("/*/*");
//        registry.addInterceptor(new ChareterSet()).addPathPatterns("/*").addPathPatterns("/*/*");
        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/*")
                .addResourceLocations("classpath:/web/");
        super.addResourceHandlers(registry);
    }

}
