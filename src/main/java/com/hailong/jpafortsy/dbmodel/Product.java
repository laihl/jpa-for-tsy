package com.hailong.jpafortsy.dbmodel;

import lombok.Data;


@Data
public class Product {
    private int productId;
    private String productName;
    private String fandian;
    private String jiliang;
    private int product_classifyId;
    private int left;
    private int unitId;

}
