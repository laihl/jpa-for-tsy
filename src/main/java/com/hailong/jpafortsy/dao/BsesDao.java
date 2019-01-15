package com.hailong.jpafortsy.dao;


import javax.sql.DataSource;

/**
 * 考虑
 * 1。aop开启事务
 * 2。关系对象映射
 * 3。jdbc查询
 * 4。mybatisXmlSQL查询
 * 5。多数据源查询
 */
public abstract class BsesDao {

    private DataSource dataSource = getDataSource();

    public abstract DataSource getDataSource();




}