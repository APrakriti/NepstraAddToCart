package com.sonika.nepstra.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.sonika.nepstra.pojo.CategoriesItem;
import com.sonika.nepstra.pojo.WomenProducts_pojo;

import java.util.ArrayList;

/**
 * Created by Prakriti on 10/16/2017.
 */

public class WomenHelper extends SQLiteOpenHelper {
    static int DATABASE_VERSION = 1;
    static String DATABASE_NAME = "women";

    String WOMEN_TABLE = "CREATE TABLE if not exists women  (\n" +
            "                       id INTEGER PRIMARY KEY ,\n" +
            "                       c_id INTEGER,\n" +
            "                       name TEXT,\n" +
            "                       price TEXT,\n" +
            "                       imageone TEXT\n" +
            "                      );";

    public WomenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        getWritableDatabase().execSQL(WOMEN_TABLE);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    } public void insertwomen(ContentValues cv) {
        getWritableDatabase().insert("women", "", cv);
        Log.e("insertvaeraxa", "yes");

    }

    public ArrayList<WomenProducts_pojo> getwomen() {
        Log.e("getOrderMessage", "vaeraxa");
        String sql = "select * from women";
        ArrayList<WomenProducts_pojo> list = new ArrayList<WomenProducts_pojo>();
        Cursor cursor = getWritableDatabase().rawQuery(sql, null);
        while (cursor.moveToNext()) {
            Log.e("movettonext", "lolo");
            // Do Somehing here
            WomenProducts_pojo orderinfo = new WomenProducts_pojo();
            orderinfo.id = cursor.getInt(cursor.getColumnIndex("id"));
            orderinfo.cid = cursor.getInt(cursor.getColumnIndex("c_id"));
            orderinfo.wname = cursor.getString(cursor.getColumnIndex("name"));
            orderinfo.wprice = cursor.getString(cursor.getColumnIndex("price"));
            orderinfo.wimage = cursor.getString(cursor.getColumnIndex("imageone"));
            list.add(orderinfo);
        }
        cursor.close();
        return list;
    }
}
