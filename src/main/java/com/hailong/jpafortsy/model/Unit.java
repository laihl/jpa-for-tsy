package com.hailong.jpafortsy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="t_Unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int base;
    private String baseName;
    private int fatherId ;
    private double price;
}
