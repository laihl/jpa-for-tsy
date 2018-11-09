package com.hailong.jpafortsy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="t_paydata")
public class PayData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String pay_id;
    private String user_id;
    private String address_id;
    private String money;
    private String payway;
    private String data;
    private String uip;
    private String create_by;
    private String charecter;
}
