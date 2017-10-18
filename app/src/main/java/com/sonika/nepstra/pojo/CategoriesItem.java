package com.sonika.nepstra.pojo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Prakriti on 10/16/2017.
 */

public class CategoriesItem extends RecyclerView.Adapter {
    public String catename, cateimage,cateprice;
    public Integer cate_id;

    public CategoriesItem() {
        }

    public CategoriesItem(String catename, String cateimage, String cateprice, Integer cate_id) {
        this.catename = catename;
        this.cateimage = cateimage;
        this.cateprice = cateprice;
        this.cate_id = cate_id;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    public String getCateimage() {
        return cateimage;
    }

    public void setCateimage(String cateimage) {
        this.cateimage = cateimage;
    }

    public String getCateprice() {
        return cateprice;
    }

    public void setCateprice(String cateprice) {
        this.cateprice = cateprice;
    }

    public Integer getCate_id() {
        return cate_id;
    }

    public void setCate_id(Integer cate_id) {
        this.cate_id = cate_id;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
