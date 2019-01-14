package com.hailong.jpafortsy.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Value("login.secret")
    private String secret;
}
