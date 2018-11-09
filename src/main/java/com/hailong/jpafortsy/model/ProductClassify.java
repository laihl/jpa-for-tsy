package com.hailong.jpafortsy.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="t_product_classify")
public class ProductClassify {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int product_classify_id;
    private int father_id;
    private String name;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "product_classify_id")
    private List<Product> productList;
}
