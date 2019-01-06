set names utf8;
set character_set_server =utf8;
set character_set_client =utf8;
set character_set_database=utf8;
set character_set_filesystem=utf8;
show variables  like 'char%';

create database test character set utf8 ;

create table t_user(
  user_id int auto_increment primary key ,
  user_name varchar(50),
  user_nickname varchar(50),
  user_pwd varchar(100)
);


