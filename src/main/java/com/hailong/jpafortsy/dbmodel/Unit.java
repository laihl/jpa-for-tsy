package com.hailong.jpafortsy.dbmodel;

import lombok.Data;

import javax.persistence.*;


@Data
//@Entity(name = "t_unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Long base;
    @Column
    private String baseName;
    @Column
    private Long fatherId ;
    @Column
    private Double price;
}
