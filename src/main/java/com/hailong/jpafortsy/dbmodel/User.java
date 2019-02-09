package com.hailong.jpafortsy.dbmodel;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity(name = "t_user")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer userId;
        @Column(insertable = false,updatable = false)
        private String userName;
        private String regDate;
        private String loginId ;
        private String userAuth;
        private String UserName;
        private String sex;
        private Double fandian;
        @Transient
        private List<Address> addressList;

}
