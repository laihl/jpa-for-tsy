package com.hailong.jpafortsy.dbmodel;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "t_address")
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer addressId;
    @Column(name="asdjkhaksdjklas")
    private Integer userId;
    private String address;
    private Double jiliang;

}
