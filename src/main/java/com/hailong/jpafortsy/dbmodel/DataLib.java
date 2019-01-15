package com.hailong.jpafortsy.dbmodel;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "t_data_lib")
public class DataLib {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long fatherId;
    @Column
    private String strId;
    @Column
    private String description;
    @Column
    private String value;
}
