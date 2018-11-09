package com.hailong.jpafortsy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="t_datalib")
public class DataLib {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int father_id;
    private String strId;
    private String desc;
    private String value;
}
