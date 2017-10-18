package com.sonika.nepstra.adapters;

/**
 * Created by Prakriti on 10/17/2017.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sonika.nepstra.R;
import com.sonika.nepstra.helpers.OrderHelper;
import com.sonika.nepstra.helpers.WomenHelper;


import com.sonika.nepstra.pojo.WomenProducts_pojo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonika on 10/16/2017.
 */

public class WomenAdapter extends BaseAdapter {
    Context context;
    List<WomenProducts_pojo> womenPoductsPojos = new ArrayList<WomenProducts_pojo>();
    int resource;
    WomenHelper dbHelper;

    public WomenAdapter(Context context, List<WomenProducts_pojo> womenPoductsPojos, int resource) {
        this.context = context;
        this.womenPoductsPojos = womenPoductsPojos;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return womenPoductsPojos.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = null;
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(resource, viewGroup, false);
            holder = new ViewHolder();

            holder.wname = row.findViewById(R.id.women_product_name);
            holder.wprice= row.findViewById(R.id.women_product_price);
            holder.wimg_product = row.findViewById(R.id.women_product_image);

            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }
        final WomenProducts_pojo orderInfo = womenPoductsPojos.get(i);

        dbHelper = new WomenHelper(context);

        //holder.orderid.setText(orderInfo.getOrderid().toString());


        holder.wname.setText("Name:"+" "+orderInfo.getWname());
        holder.wprice.setText("Price:" + " "+orderInfo.getWprice());
        Picasso.with(context).load(orderInfo.getWimage()).into(holder.wimg_product);


        return row;
    }

    static class ViewHolder {
        TextView wname, wprice, wid, wcid;

        ImageView wimg_product;
    }

}