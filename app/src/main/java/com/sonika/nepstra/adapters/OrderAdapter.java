package com.sonika.nepstra.adapters;

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
import com.sonika.nepstra.listener.ListViewListener;
import com.sonika.nepstra.pojo.AllProducts;
import com.sonika.nepstra.pojo.OrderedProducts_pojo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonika on 5/9/2017.
 */

public class OrderAdapter extends BaseAdapter{
    Context context;
    List<OrderedProducts_pojo> objects = new ArrayList<OrderedProducts_pojo>();
    int resource;
    OrderHelper dbHelper;
    private ListViewListener mListener;

    public OrderAdapter(Context context, List<OrderedProducts_pojo> objects, int resource) {
        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return objects.size();
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(resource, parent, false);
            holder = new ViewHolder();

            holder.name = row.findViewById(R.id.ordered_productlist_name);
            holder.price= row.findViewById(R.id.ordered_productlist_price);
            holder.img_product = row.findViewById(R.id.ordered_productlist_image);
            holder.orderid = row.findViewById(R.id.ordered_productlist_id);
            holder.btnRemove = row.findViewById(R.id.btn_remove);
            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }
        final OrderedProducts_pojo orderInfo = objects.get(position);

        dbHelper = new OrderHelper(context);

        //holder.orderid.setText(orderInfo.getOrderid().toString());


        holder.name.setText("Name:"+" "+orderInfo.getOrderedname());
        holder.price.setText("Price:" + " "+orderInfo.getOrderedprice());
        Picasso.with(context).load(orderInfo.getOrderedimage()).into(holder.img_product);
        holder.orderid.setText(position + 1 +" ");
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dbHelper.delete(orderInfo.getOrderid().toString(), null, null);
                dbHelper.delete(objects.get(position).getOrderid()
                        .toString(), null, null);
                Toast.makeText(context, "removed", Toast.LENGTH_SHORT).show();
                mListener.getMyTotal();
                objects.remove(position);
                notifyDataSetChanged();
            }
        });
        return row;
    }
    public void setListener(ListViewListener listener) {
        mListener = listener;
    }



    static class ViewHolder {
        TextView name, price, orderid;
        Button btnRemove;
        ImageView img_product;
    }
}