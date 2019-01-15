package com.hailong.jpafortsy.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class ChareterSet  extends HandlerInterceptorAdapter implements Ordered {

     private static final int level = 0;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("============ChareterSet interceptor===============");
        return super.preHandle(request, response, handler);

    }

    @Override
    public int getOrder() {
        return level;
    }
}
