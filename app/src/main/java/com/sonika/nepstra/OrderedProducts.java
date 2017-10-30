package com.sonika.nepstra;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.sonika.nepstra.adapters.OrderAdapter;
import com.sonika.nepstra.helpers.OrderHelper;
import com.sonika.nepstra.listener.ListViewListener;
import com.sonika.nepstra.pojo.OrderedProducts_pojo;

import java.util.ArrayList;
import java.util.List;

;

/**
 * Created by sonika on 9/22/2017.
 */

public class OrderedProducts extends AppCompatActivity implements ListViewListener {
    Button checkout;
    //RecyclerView orders_recyclerView;
    ListView lv;
    OrderHelper dbhelper;
    OrderAdapter mOrderAdapter;
    List<OrderedProducts_pojo> orderedProductsList = new ArrayList<>();
    TextView totalAmount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordered_products);
        checkout = (Button) findViewById(R.id.btn_proceed_add_to_cart);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OrderedProducts.this, PaypalActivity.class);
                startActivity(i);
            }
        });
        dbhelper = new OrderHelper(this);
        lv = (ListView) findViewById(R.id.ordered_productlist);
        totalAmount = (TextView) findViewById(R.id.totalamount);
        getMyTotal();
        show();
    }

    public void show() {
        orderedProductsList = dbhelper.getOrderMessage();
        for (int i = 0; i < orderedProductsList.size(); i++) {
            final OrderedProducts_pojo info = orderedProductsList.get(i);
            mOrderAdapter = new OrderAdapter(this, orderedProductsList, R.layout.ordered_productlist);
            mOrderAdapter.setListener(this);
            lv.setAdapter(mOrderAdapter);
            lv.deferNotifyDataSetChanged();
        }
    }

    @Override
    public void getMyTotal() {

        String result = dbhelper.GetTotal();
        totalAmount.setText("Your Toatl Bill Amount Is : " +result);

    }
}
