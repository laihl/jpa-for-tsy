package com.hailong.jpafortsy.dao;

import com.hailong.jpafortsy.DbBase.DbBase;
import com.hailong.jpafortsy.dbmodel.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserDao  {
    @Transactional
    public void addUser(User user) ;
}
