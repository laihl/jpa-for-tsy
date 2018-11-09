package com.hailong.jpafortsy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="t_orderlist")
public class OrderList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String orderId;
    private Date regIate;
    private String odernumber;
     private double price;
    private String huansuan;
    private char chareter;
    private char state;
    private String massage;
    private String wuliu;
    private int admin;
    private int adress_id;
    private int userId;
    private String gustphone;
    private String deletedata;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="order_id")
    private List<OrderDetail> orderDetailList;
}
