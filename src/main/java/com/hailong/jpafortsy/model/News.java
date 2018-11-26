package com.hailong.jpafortsy.model;

import lombok.Data;


@Data
public class News {

    private String id;
    private String title;
    private String regDate;
    private String context;
    private String author;
    private String good;
    private String top;
}
