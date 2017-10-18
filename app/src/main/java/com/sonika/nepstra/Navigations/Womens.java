package com.sonika.nepstra.Navigations;

/**
 * Created by Prakriti on 10/17/2017.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.sonika.nepstra.R;
import com.sonika.nepstra.adapters.OrderAdapter;
import com.sonika.nepstra.adapters.WomenAdapter;
import com.sonika.nepstra.helpers.OrderHelper;
import com.sonika.nepstra.helpers.WomenHelper;
import com.sonika.nepstra.pojo.WomenProducts_pojo;

import java.util.ArrayList;
import java.util.List;

public class Womens extends AppCompatActivity {
    ListView lv;
    WomenHelper dbhelper;
    WomenAdapter womenAdapter;
    List<WomenProducts_pojo> womenPoductsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_womens);
        dbhelper = new WomenHelper(this);
        lv = (ListView) findViewById(R.id.women_productlist);
        showWomenProducts();
    }

    private void showWomenProducts() {
        womenPoductsList = dbhelper.getwomen();
        for (int i = 0; i < womenPoductsList.size(); i++) {
            final WomenProducts_pojo info = womenPoductsList.get(i);
            womenAdapter= new WomenAdapter(this, womenPoductsList, R.layout.women_list);
            lv.setAdapter(womenAdapter);
            lv.deferNotifyDataSetChanged();
        }
    }
}
