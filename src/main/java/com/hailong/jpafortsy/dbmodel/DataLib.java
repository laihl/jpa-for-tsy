package com.hailong.jpafortsy.dbmodel;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "t_data_lib")
public class DataLib {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long fatherId;
    private String strId;
    private String description;
    private String value;
}
