package com.hailong.jpafortsy.dbmodel;

import lombok.Data;

import javax.persistence.*;


@Data
//@Entity(name = "t_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    @Column
    private String productName;
    @Column
    private Double fandian;
    @Column
    private Double jiliang;
    @Column
    private Long product_classifyId;
    @Column
    private Long left;
    @Column
    private Long unitId;

}
