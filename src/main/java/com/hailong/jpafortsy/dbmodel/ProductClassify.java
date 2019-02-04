package com.hailong.jpafortsy.dbmodel;


import lombok.Data;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

import javax.persistence.*;
import java.util.List;

@Data
//@Entity(name = "t_product_classify")
public class ProductClassify {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productClassifyId;
    private Long fatherId;
    private String name;
    private List<Product> productList;
}
