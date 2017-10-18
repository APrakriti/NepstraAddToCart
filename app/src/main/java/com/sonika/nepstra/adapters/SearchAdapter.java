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
import android.widget.ImageView;
import android.widget.TextView;

import com.sonika.nepstra.R;
import com.sonika.nepstra.Search;
import com.sonika.nepstra.helpers.SearchHelper;

import com.sonika.nepstra.pojo.SearchPojo;
import com.sonika.nepstra.pojo.WomenProducts_pojo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonika on 10/16/2017.
 */

public class SearchAdapter extends BaseAdapter {
    Context context;
    List<SearchPojo> searches = new ArrayList<SearchPojo>();
    int resource;
    SearchHelper dbHelper;

    public SearchAdapter(Context context, List<SearchPojo> searches, int resource, SearchHelper dbHelper) {
        this.context = context;
        this.searches = searches;
        this.resource = resource;
        this.dbHelper = dbHelper;
    }

    public SearchAdapter(Search search, List<SearchPojo> searchlist, int search_list) {

    }

    @Override
    public int getCount() {
        return searches.size();
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

            holder.wname = row.findViewById(R.id.search_product_name);
            holder.wprice= row.findViewById(R.id.search_product_price);
            holder.wimg_product = row.findViewById(R.id.search_product_image);

            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }
        final SearchPojo orderInfo = searches.get(i);

        dbHelper = new SearchHelper(context);

        //holder.orderid.setText(orderInfo.getOrderid().toString());


        holder.wname.setText("Name:"+" "+orderInfo.getSname());
        holder.wprice.setText("Price:" + " "+orderInfo.getSprice());
        Picasso.with(context).load(orderInfo.getSimage()).into(holder.wimg_product);


        return row;
    }

    static class ViewHolder {
        TextView wname, wprice, wid, wcid;

        ImageView wimg_product;
    }

}