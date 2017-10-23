package com.sonika.nepstra.adapters;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import com.sonika.nepstra.DetailsActivity;
import com.sonika.nepstra.R;
import com.sonika.nepstra.helpers.CategoriesHelper;
import com.sonika.nepstra.helpers.MySharedPreference;
import com.sonika.nepstra.helpers.NewArrivalHelper;
import com.sonika.nepstra.helpers.OrderHelper;
import com.sonika.nepstra.helpers.SearchHelper;
import com.sonika.nepstra.helpers.WomenHelper;
import com.sonika.nepstra.pojo.AllProducts;
import com.sonika.nepstra.pojo.NewArrivalProducts_pojo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by sonika on 9/19/2017.
 */

public class AllProductAdapter extends RecyclerView.Adapter<AllProductHolder> {
    public Context context;
    private List<AllProducts> allProductList = null;
   // private List<AllProducts> allNamesList = null;
    ArrayList<AllProducts> arraylist;
    MySharedPreference sharedPreference;
    Gson gson;
    private int cartProductNumber = 0;
    String oname, oprice, oimage;
    Integer c_id;
    CategoriesHelper categoriesHelper;
    WomenHelper womenHelper;
    SearchHelper searchHelper;
    OrderHelper dbHelper;
    NewArrivalHelper newArrivalHelper;


    public AllProductAdapter(Context context, List<AllProducts> allProductList) {
        this.context = context;
        this.allProductList = allProductList;

    }
    /* public AllProductAdapter(Context context, List<AllProducts> allproductList) {
        this.context = context;
        this.allProductList = allproductList;*/


    @Override
    public AllProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.all_productlist, parent, false);
        dbHelper = new OrderHelper(context);
        womenHelper = new WomenHelper(context);
        newArrivalHelper = new NewArrivalHelper(context);
        searchHelper = new SearchHelper(context);
        return new AllProductHolder(view);
    }

    @Override
    public void onBindViewHolder(AllProductHolder allholder, final int position) {
        allholder.allproductName.setText(allProductList.get(position).getName());
        allholder.allproductPrice.setText("$" +allProductList.get(position).getPrice());
        Picasso.with(context).load(allProductList.get(position).getI_src()).into(allholder.allproductImage);

        Log.e("chankhey", "monkey");


        allholder.viewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllProducts intentprod = allProductList.get(position);
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("hello", intentprod);
                context.startActivity(intent);
            }
        });

        allholder.addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Added to cart", Toast.LENGTH_SHORT).show();

                oname = allProductList.get(position).getName();
                oprice = allProductList.get(position).getPrice();
                oimage = allProductList.get(position).getI_src();

                ContentValues contentValues = new ContentValues();
                contentValues.put("name" , oname);
                contentValues.put("price" , oprice);
                contentValues.put("imageone" , oimage);
//                Log.e("pizza", "lovet");
//                Log.e("momo", oname);
//                Log.e("burger", oprice);
//                Log.e("oooo", oimage);
                dbHelper.insertOrderInfo(contentValues);
            }
        });
        oname = allProductList.get(position).getName();
        oprice = allProductList.get(position).getPrice();
        oimage = allProductList.get(position).getI_src();
        c_id = allProductList.get(position).getC_id();
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put("c_id", c_id);
        contentValues1.put("name", oname);
        contentValues1.put("price", oprice);
        contentValues1.put("imageone", oimage);
        searchHelper.insertsearch(contentValues1);

        if (c_id==29){
            ContentValues contentValues = new ContentValues();
            contentValues.put("c_id", c_id);
            contentValues.put("name", oname);
            contentValues.put("price", oprice);
            contentValues.put("imageone", oimage);
            womenHelper.insertwomen(contentValues);
        }
//        oname = allProductList.get(position).getName();
//        oprice = allProductList.get(position).getPrice();
//        oimage = allProductList.get(position).getI_src();
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name" , oname);
//        contentValues.put("price" , oprice);
//        contentValues.put("imageone" , oimage);
//        searchHelper.insertsearch(contentValues);
    }


    @Override
    public int getItemCount() {
        //Log.e("sanjeev", String.valueOf(allProductList.size()));
        return allProductList.size();
    }


    public void filterData(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        allProductList.clear();
        if (charText.length() == 0) {
           allProductList.addAll(arraylist);
        } else {
            for (AllProducts wp : arraylist) {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    allProductList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}








