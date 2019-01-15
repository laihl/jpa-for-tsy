package com.hailong.jpafortsy.dbmodel;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "t_address")
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long addressId;
    @Column
    private Integer userId;
    @Column
    private String address;
    @Column
    private Double jiliang;

}
