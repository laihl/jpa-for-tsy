package com.hailong.jpafortsy.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="t_product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int product_id;
    private String product_name;
    private boolean fandian;
    private boolean jiliang;
    private int product_classify_id;
    private int left;
    private int unit_id;

}
