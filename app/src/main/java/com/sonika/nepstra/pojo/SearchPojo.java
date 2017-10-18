package com.sonika.nepstra.pojo;



/**
 * Created by Prakriti on 10/17/2017.
 */

public class SearchPojo {
    public String sname, simage , sprice;
    public Integer sid;
    public Integer newid;

    public SearchPojo(){
    }
    public SearchPojo(String sname, String simage, String sprice, Integer sid, Integer newid) {
        this.sname = sname;
        this.simage = simage;
        this.sprice = sprice;
        this.sid = sid;
        this.newid = newid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSimage() {
        return simage;
    }

    public void setSimage(String simage) {
        this.simage = simage;
    }

    public String getSprice() {
        return sprice;
    }

    public void setSprice(String sprice) {
        this.sprice = sprice;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getNewid() {
        return newid;
    }

    public void setNewid(Integer newid) {
        this.newid = newid;
    }
}