package com.hailong.jpafortsy.DbBase.utils;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Page<T> {
    private  int pageSize;
    private  int pageNum;
    private  int totalPage;
    private  int totalSize;
    private List<T> data;

    public Page(List<T> data,int pageSize,int pageNum){
        this.data =data;
        this.pageNum=pageNum;
        if (pageNum<=0){
            this.pageNum=1;
        }
        if (pageSize<5){
            this.pageSize=20;
        }
        List<T> listData = new ArrayList<>();



    }

    public Page(List<T> data,int pageSize,int pageNum,int totalPage,int totalSize){
        this.data =data;
        this.pageNum=pageNum;
        this.pageSize=pageSize;
        this.totalPage=totalPage;
        this.totalSize=totalSize;
    }
    public Page(){
    }



}
