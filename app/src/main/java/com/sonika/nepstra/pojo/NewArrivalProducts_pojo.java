package com.sonika.nepstra.pojo;

/**
 * Created by Prakriti on 10/17/2017.
 */

public class NewArrivalProducts_pojo {

    public String newname, newprice, newimage;
    public Integer newid;
    public Integer cid;
    public  NewArrivalProducts_pojo(){

    }

    public NewArrivalProducts_pojo(String newname, String newprice, String newimage, Integer newid, Integer cid) {
        this.newname = newname;
        this.newprice = newprice;
        this.newimage = newimage;
        this.newid = newid;
        this.cid = cid;
    }

    public String getNewname() {
        return newname;
    }

    public void setNewname(String newname) {
        this.newname = newname;
    }

    public String getNewprice() {
        return newprice;
    }

    public void setNewprice(String newprice) {
        this.newprice = newprice;
    }

    public String getNewimage() {
        return newimage;
    }

    public void setNewimage(String newimage) {
        this.newimage = newimage;
    }

    public Integer getNewid() {
        return newid;
    }

    public void setNewid(Integer newid) {
        this.newid = newid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
