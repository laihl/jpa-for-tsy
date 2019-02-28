package com.hailong.jpafortsy.bean;

import lombok.Data;

@Data
public class ResultAll {
    private Integer code = 1;
    private String message;
    private Object data;
}
