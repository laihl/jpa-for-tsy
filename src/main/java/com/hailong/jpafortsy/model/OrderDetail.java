package com.hailong.jpafortsy.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="t_orderDetail")
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int OrderDetail_id;
    private int order_id;
    private int product_id;
    private String         product_name;
    private int quantity;
    private double price;
    private double danjia;
    private int danwei;
    private String danweiname;
    private String danweiupname;
    private int danweiupjishu;
    private double xiaoji;
    private boolean jiliang;
    private double      fandian;

}
