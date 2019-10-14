package com.hailong.jpafortsy.dao;

import com.hailong.jpafortsy.DbBase.DbBase;
import com.hailong.jpafortsy.dbmodel.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;


@Repository
public class UserDaoTemplat extends DbBase {
    @Transactional
    public void addUser(User user) throws SQLException, IllegalAccessException {
        insert(user);
        if (false){
            throw new RuntimeException("test Transaction");
        }
    }
}
