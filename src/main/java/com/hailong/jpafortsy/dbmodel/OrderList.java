package com.hailong.jpafortsy.dbmodel;

import lombok.Data;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "t_order_list")
public class OrderList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Date regIate;
    private String odernumber;
    private Double price;
    private String huansuan;
    private String chareter;
    private String state;
    private String massage;
    private String wuliu;
    private String admin;
    private Integer adressId;
    private Integer userId;
    private String gustphone;
    private String deletedata;
    @Transient
    private List<OrderDetail> orderDetailList;
}
