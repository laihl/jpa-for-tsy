package com.hailong.jpafortsy.model;


import lombok.Data;

import java.util.List;

@Data
public class ProductClassify {

    private int productClassifyId;
    private int fatherId;
    private String name;
    private List<Product> productList;
}
