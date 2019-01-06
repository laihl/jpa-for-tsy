package com.hailong.jpafortsy.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverclass;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String pwd;
    @Value("${spring.datasource.url}")
    private String url;

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setDriverClass(driverclass);
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(pwd);
        comboPooledDataSource.setInitialPoolSize(2);//初始化池大小
        comboPooledDataSource.setMaxStatements(50);//每次最多可以执行多少个批处理语句
        comboPooledDataSource.setMaxPoolSize(10);//最多有多少个连接
        comboPooledDataSource.setMinPoolSize(2);//最少几个连接
        comboPooledDataSource.setAcquireIncrement(5);//如果池中数据连接不够时一次增长多少个
        comboPooledDataSource.setMaxIdleTime(30);//最大空闲时间
        return comboPooledDataSource;
    }
}
