package com.hailong.jpafortsy.dao;

import com.hailong.jpafortsy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {}