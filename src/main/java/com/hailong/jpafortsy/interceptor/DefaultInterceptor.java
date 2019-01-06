package com.hailong.jpafortsy.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
@Slf4j
public class DefaultInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("==========================================default interceptor start===================================================");
        log.info("getMethod:"+request.getMethod());
        log.info("getRequestURI:"+request.getRequestURI());
        log.info("getPathInfo:"+request.getPathInfo());
        log.info("getServletPath:"+request.getServletPath());
        log.info("getQueryString:"+request.getQueryString());
        log.info("getRequestedSessionId:"+request.getRequestedSessionId());
//        HttpSession session = request.getSession();
//        session.setAttribute("test","1");
//        log.info("getSession:");
//        Enumeration<String> attributeNames = session.getAttributeNames();
//        while (attributeNames.hasMoreElements()){
//            String s = attributeNames.nextElement();
//            log.info("getSession:"+s+":"+session.getAttribute(s));
//        }
        log.info("getHeaderNames:");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            log.info("getHeaderNames:" + s+":"+request.getHeader(s));
        }

        log.info("==========================================default interceptor end===================================================");

        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
