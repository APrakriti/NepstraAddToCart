package com.sonika.nepstra.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

import com.sonika.nepstra.pojo.SearchPojo;
import com.sonika.nepstra.pojo.WomenProducts_pojo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by Prakriti on 10/17/2017.
 */

public class SearchHelper  extends SQLiteOpenHelper {


    static int DATABASE_VERSION = 1;
    static String DATABASE_NAME = "search";

    String SEARCH_TABLE = "CREATE TABLE if not exists search  (\n" +
            "                       id INTEGER PRIMARY KEY ,\n" +
            "                       c_id INTEGER,\n" +
            "                       name TEXT,\n" +
            "                       price TEXT,\n" +
            "                       imageone TEXT\n" +
            "                      );";

    public SearchHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        getWritableDatabase().execSQL(SEARCH_TABLE);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertsearch(ContentValues cv) {
        getWritableDatabase().insert("search", "", cv);
        Log.e("insertvaeraxa", "yes");

    }

    public ArrayList<SearchPojo> getSearch() {
        Log.e("getOrderMessage", "vaeraxa");
        String sql = "select * from search";
        ArrayList<SearchPojo> list = new ArrayList<SearchPojo>();
        Cursor cursor = getWritableDatabase().rawQuery(sql, null);
        while (cursor.moveToNext()) {
            Log.e("movettonext", "lolo");
            // Do Somehing here
            SearchPojo search = new SearchPojo();
            search.newid = cursor.getInt(cursor.getColumnIndex("id"));
            search.sid = cursor.getInt(cursor.getColumnIndex("c_id"));
            search.sname = cursor.getString(cursor.getColumnIndex("name"));
            search.sprice = cursor.getString(cursor.getColumnIndex("price"));
            search.simage = cursor.getString(cursor.getColumnIndex("imageone"));
            list.add(search);
        }
        cursor.close();
        return list;
    }

}