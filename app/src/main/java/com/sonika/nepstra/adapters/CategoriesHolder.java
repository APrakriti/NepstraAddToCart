package com.sonika.nepstra.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sonika.nepstra.R;


/**
 * Created by sonika on 9/19/2017.
 */

public class CategoriesHolder extends RecyclerView.ViewHolder {
    public ImageView allproductImage;
    public TextView allproductName, allproductPrice;
    public Button addtocart, viewMore;


    public CategoriesHolder(View itemView) {
        super(itemView);
        allproductName = itemView.findViewById(R.id.cate_id_name);
        allproductImage = itemView.findViewById(R.id.cate_id_image);


    }
}
