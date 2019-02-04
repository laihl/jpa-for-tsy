package com.hailong.jpafortsy.dbmodel;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "t_order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OrderDetailId;
    @Column
    private Long productId;
    @Column
    private String productName;
    @Column
    private Integer quantity;
    @Column
    private Double price;
    @Column
    private Double danjia;
    @Column
    private Integer danwei;
    @Column
    private String danweiname;
    @Column
    private String danweiupname;
    @Column
    private Integer danweiupjishu;
    @Column
    private Double xiaoji;
    @Column
    private String jiliang;
    @Column
    private Double fandian;

}
