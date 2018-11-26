package com.hailong.jpafortsy.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderList {

    private String orderId;
    private Date regIate;
    private String odernumber;
     private double price;
    private String huansuan;
    private String chareter;
    private String state;
    private String massage;
    private String wuliu;
    private int admin;
    private int adressId;
    private int userId;
    private String gustphone;
    private String deletedata;
    private List<OrderDetail> orderDetailList;
}
