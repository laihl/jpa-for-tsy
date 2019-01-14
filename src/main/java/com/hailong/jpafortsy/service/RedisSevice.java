package com.hailong.jpafortsy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisSevice {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    public void set(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    public String get(String key){
        return  redisTemplate.opsForValue().get(key);
    }

}
