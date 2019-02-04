package com.hailong.jpafortsy.dbmodel;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
//@Entity(name = "t_user")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long userId;
        @Column
        private String userName;
        @Column
        private String regDate;
        @Column
        private String loginId ;
        @Column
        private String userAuth;
        @Column
        private String UserName;
        @Column
        private String sex;
        @Column
        private Double fandian;
        private List<Address> addressList;

}
