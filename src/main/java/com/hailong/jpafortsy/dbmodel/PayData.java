package com.hailong.jpafortsy.dbmodel;

import lombok.Data;

import javax.persistence.*;


@Data
//@Entity(name = "t_pay_data")
public class PayData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long payId;
    @Column
    private Long userId;
    @Column
    private Long addressId;
    @Column
    private Double money;
    @Column
    private String payway;
    @Column
    private String data;
    @Column
    private String uip;
    @Column
    private String createBy;
    @Column
    private String charecter;
}
