package com.hailong.jpafortsy.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="t_news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String title;
    private String reg_date;
    private String context;
    private String author;
    private char good;
    private char top;
}
