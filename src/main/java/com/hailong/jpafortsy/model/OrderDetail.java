package com.hailong.jpafortsy.model;

import lombok.Data;


@Data
public class OrderDetail {
    private int OrderDetailId;
    private int orderId;
    private int productId;
    private String         productName;
    private int quantity;
    private double price;
    private double danjia;
    private int danwei;
    private String danweiname;
    private String danweiupname;
    private int danweiupjishu;
    private double xiaoji;
    private String jiliang;
    private double      fandian;

}
