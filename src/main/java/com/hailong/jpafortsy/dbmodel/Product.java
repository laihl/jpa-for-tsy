package com.hailong.jpafortsy.dbmodel;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "t_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    private String productName;
    private Double fandian;
    private Double jiliang;
    private Integer product_classifyId;
    private Integer productLeft;
    private Integer unitId;

}
