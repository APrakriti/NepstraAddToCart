package com.sonika.nepstra;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
//        orders_recyclerView = (RecyclerView) findViewById(R.id.or);
//        //Toast.makeText(this, orderedProducts.getOrderedname(), Toast.LENGTH_SHORT).show();
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(OrderedProducts.this);
//        orders_recyclerView.setLayoutManager(linearLayoutManager);
//        orders_recyclerView.setHasFixedSize(true);
//        OrderedProductsAdapter orderAdapter = new OrderedProductsAdapter
//                (getApplicationContext(), orderedProductsList);
//        orders_recyclerView.setAdapter(orderAdapter);




      //  Toast.makeText(this, allProducts.getName(), Toast.LENGTH_SHORT).show();

//adding to cart

//        MySharedPreference mShared = new MySharedPreference(OrderedProducts_pojo.this);
//
//        GsonBuilder builder = new GsonBuilder();
//        Gson gson = builder.create();
//        AllProducts[] addCartProducts = gson.fromJson(mShared.retrieveProductFromCart(), AllProducts[].class);
//        List<AllProducts> productList = convertObjectArrayToListObject(addCartProducts);

//        OrderedProductsAdapter mAdapter = new OrderedProductsAdapter(getApplicationContext(), productList);
//        orders_recyclerView.setAdapter(mAdapter);
//    }
//
//    private List<AllProducts> convertObjectArrayToListObject(AllProducts[] allProducts){
//       // final AllProducts allProductsa = (AllProducts) getIntent().getSerializableExtra("hello");
//        //List<AllProducts> mProduct = new ArrayList<AllProducts>();
//        AllProducts mProduct =(AllProducts) getIntent().getSerializableExtra("hello");
//        allProductList.add(mProduct);
//        Collections.addAll(allProductList, allProducts);
//        return allProductList;
//   }
//}
