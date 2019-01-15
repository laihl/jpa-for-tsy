#数据库参数初始化
set names utf8;
set character_set_server =utf8;
set character_set_client =utf8;
set character_set_database=utf8;
set character_set_filesystem=utf8;
show variables  like 'char%';
#创建数据库
drop database if exists test;
create database test character set utf8 ;

#用户表创建
drop table if exists t_user;
create table t_user(
  user_id int auto_increment primary key ,
  user_name varchar(50),
  user_nickname varchar(50),
  user_pwd varchar(100)
);

drop table if exists t_user_ext;
create table t_user_ext(
  ext_id int auto_increment primary key ,
  reward float(3,3) default 0.0,
  mission int default 0
);

