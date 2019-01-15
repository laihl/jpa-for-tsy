package com.hailong.jpafortsy.dbmodel;

import lombok.Data;


@Data
public class PayData {
    private String payId;
    private String userId;
    private String addressId;
    private String money;
    private String payway;
    private String data;
    private String uip;
    private String createBy;
    private String charecter;
}
