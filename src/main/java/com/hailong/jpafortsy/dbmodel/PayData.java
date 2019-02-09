package com.hailong.jpafortsy.dbmodel;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "t_pay_data")
public class PayData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer payId;
    private Integer userId;
    private Integer addressId;
    private Double money;
    private String payway;
    private String data;
    private String uip;
    private String createBy;
    private String charecter;
}
