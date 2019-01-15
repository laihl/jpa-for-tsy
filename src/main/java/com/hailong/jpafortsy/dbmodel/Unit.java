package com.hailong.jpafortsy.dbmodel;

import lombok.Data;


@Data
public class Unit {
    private int id;
    private int base;
    private String baseName;
    private int fatherId ;
    private double price;
}
