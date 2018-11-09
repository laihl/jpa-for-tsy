package com.hailong.jpafortsy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="t_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int address_id;
    private int user_id;
    private String address;
    private double jiliang;

}
