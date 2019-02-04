package com.hailong.jpafortsy.dbmodel;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "t_news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String regDate;
    @Column
    private String context;
    @Column
    private Long authorUser;
    @Column
    private String good;
    @Column
    private String top;
    @Column
    private String type;
}
