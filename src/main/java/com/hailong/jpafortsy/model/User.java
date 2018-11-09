package com.hailong.jpafortsy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name="t_user")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int userId;
        private String userName;
        private Date reg_date;
        private String loginId ;
        private String auth;
        private String name;
        private String sex;
        private double fandian;
        @OneToMany(cascade = {CascadeType.ALL})
        @JoinColumn(name="user_id")
        private List<Address> addressList;

}
