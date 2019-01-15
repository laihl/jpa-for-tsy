package com.hailong.jpafortsy.dbmodel;

import lombok.Data;

import java.util.List;


@Data
public class User {
        private int userId;
        private String userName;
        private String regDate;
        private String loginId ;
        private String auth;
        private String name;
        private String sex;
        private double fandian;
        private List<Address> addressList;

}
