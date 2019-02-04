package com.hailong.jpafortsy.dbmodel;

import lombok.Data;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
//@Entity(name = "t_order_list")
public class OrderList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @Column
    private Date regIate;
    @Column
    private String odernumber;
    @Column
    private Double price;
    @Column
    private String huansuan;
    @Column
    private String chareter;
    @Column
    private String state;
    @Column
    private String massage;
    @Column
    private String wuliu;
    @Column
    private String admin;
    @Column
    private Long adressId;
    @Column
    private Long userId;
    @Column
    private String gustphone;
    @Column
    private String deletedata;
    @IgnoreForbiddenApisErrors(reason = "")
    private List<OrderDetail> orderDetailList;
}
