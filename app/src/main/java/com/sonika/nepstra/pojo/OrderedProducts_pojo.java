package com.sonika.nepstra.pojo;

/**
 * Created by sonika on 9/23/2017.
 */

public class OrderedProducts_pojo {
    public String orderedname, orderedprice, orderedimage;
    public Integer orderid;

    public OrderedProducts_pojo() {
    }

    public OrderedProducts_pojo(String orderedname, String orderedprice, String orderedimage, Integer orderid) {
        this.orderedname = orderedname;
        this.orderedprice = orderedprice;
        this.orderedimage = orderedimage;
        this.orderid = orderid;
    }

    public String getOrderedname() {
        return orderedname;
    }

    public void setOrderedname(String orderedname) {
        this.orderedname = orderedname;
    }

    public String getOrderedprice() {
        return orderedprice;
    }

    public void setOrderedprice(String orderedprice) {
        this.orderedprice = orderedprice;
    }

    public String getOrderedimage() {
        return orderedimage;
    }

    public void setOrderedimage(String orderedimage) {
        this.orderedimage = orderedimage;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }
}