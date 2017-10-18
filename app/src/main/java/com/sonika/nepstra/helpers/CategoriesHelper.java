package com.sonika.nepstra.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.sonika.nepstra.pojo.CategoriesItem;
import com.sonika.nepstra.pojo.OrderedProducts_pojo;

import java.util.ArrayList;

/**
 * Created by Prakriti on 10/16/2017.
 */

public class CategoriesHelper  extends SQLiteOpenHelper {
    static int DATABASE_VERSION = 2;
    static String DATABASE_NAME = "user_orders";

    String ORDER_TABLE = "CREATE TABLE if not exists `user_orders`  (\n" +
            "                       `id` INTEGER PRIMARY KEY ,\n" +
            "                       `cat_id` INTEGER PRIMARY KEY ,\n" +
            "                       `name` TEXT,\n" +
            "                       `price` TEXT,\n" +
            "                       `imageone` TEXT\n" +
            "                      );";

    public CategoriesHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        getWritableDatabase().execSQL(ORDER_TABLE);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    } public void insertOrderInfo(ContentValues cv) {
        getWritableDatabase().insert("user_orders", "", cv);
        Log.e("insertvaeraxa", "yes");

    }

    public ArrayList<CategoriesItem> getOrderMessage() {
        Log.e("getOrderMessage", "vaeraxa");
        String sql = "select * from user_orders";
        ArrayList<CategoriesItem> list = new ArrayList<CategoriesItem>();
        Cursor cursor = getWritableDatabase().rawQuery(sql, null);
        while (cursor.moveToNext()) {
            Log.e("movettonext", "lolo");
            // Do Somehing here
            CategoriesItem cateItem = new CategoriesItem();
            cateItem.cate_id = cursor.getInt(cursor.getColumnIndex("id"));
            cateItem.catename = cursor.getString(cursor.getColumnIndex("name"));
            cateItem.cateprice = cursor.getString(cursor.getColumnIndex("price"));
            cateItem.cateimage = cursor.getString(cursor.getColumnIndex("imageone"));
            list.add(cateItem);
        }
        cursor.close();
        return list;
    }


    //    public void delete(String id, Object name, Object amount) {
//        getWritableDatabase().delete("user_order", "id = ?" +id, new String[] { String.valueOf(id) });
//        Log.e("deletinsqlite", "ghijklmnop");
//    }



}
