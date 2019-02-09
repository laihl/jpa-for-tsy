package com.hailong.jpafortsy.dbmodel;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "t_order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer OrderDetailId;
    private Integer productId;
    private String productName;
    private Integer quantity;
    private Double price;
    private Double danjia;
    private Integer danwei;
    private String danweiname;
    private String danweiupname;
    private Integer danweiupjishu;
    private Double xiaoji;
    private String jiliang;
    private Double fandian;

}
