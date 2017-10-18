package com.sonika.nepstra.fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.sonika.nepstra.R;
import com.sonika.nepstra.adapters.MycustomAdapter;
import com.sonika.nepstra.parser.JsonParserA;
import com.sonika.nepstra.pojo.AllProducts;
import com.sonika.nepstra.pojo.MyData;
import com.sonika.nepstra.pojo.ProductObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 *////commentPrakriti
public class categories_fragment extends Fragment {
    SearchView searchView;
    ListView searchresults;
    EditText searchBox;

    HashMap<String, String> loginHashMap = new HashMap<>();
    ArrayList<AllProducts> productResults = new ArrayList<AllProducts>();
    //Based on the search string, only filtered products will be moved here from productResults
    ArrayList<AllProducts> filteredProductResults = new ArrayList<AllProducts>();

    public categories_fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_categories, container, false);



   perform(v);
        return v;
    }

    public void perform(View v)
    {
        new ProductAsyncTask().execute();
    }

        class ProductAsyncTask extends AsyncTask<String, String, String> {


            ProgressDialog mprogressDialog;

            RecyclerView mrecyclerView;
            int flag;
            List<MyData> data_list = new ArrayList<>();
            List<ProductObject> ProductList = new ArrayList<ProductObject>();
            List<ProductObject> filteredlist = new ArrayList<ProductObject>();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();


                mprogressDialog = new ProgressDialog(getContext());
                mprogressDialog.setMessage("Please wait");
                mprogressDialog.setCancelable(false);
                mprogressDialog.show();


            }

            @Override
            protected String doInBackground(String... params) {
                HashMap<String, String> loginHashMap = new HashMap<>();
                JsonParserA jsonParser = new JsonParserA();
                JSONObject jsonObject = jsonParser.performPostCI("https://nepstra.com/api/android/categories.php", loginHashMap);
                // Log.e("monkey", "sam");
                String request = "";

                try {
                    if (jsonObject == null) {
                        flag = 1;

                    } else if (jsonObject.getString("status").equals("success")) {
                        JSONArray jsonArray=jsonObject.getJSONArray("data");
                        System.out.println(jsonArray.length());


                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject object = jsonArray.getJSONObject(i);
                            Log.e("monkey", "prakriti");

                            Integer id = object.getInt("id");
                            String name = object.getString("name");
                            String slug = object.getString("slug");
                            Integer parent = object.getInt("parent");
                            Log.e("monkey", "prak");
                            String description = object.getString("description");
                            String display = object.getString("display");
                            Log.e("monkey", "sonika");


                            // Image node is JSON Object
                            JSONObject image = object.getJSONObject("image");
                            Integer image_id  = image.getInt("id");
                            String date_created = image.getString("date_created");
                            String date_created_gmt =image.getString("date_created_gmt");
                            String date_modified =image.getString("date_modified");
                            String date_modified_gmt =image.getString("date_modified_gmt");
                            String src =image.getString("src");
                            String title =image.getString("title");
                            String alt =image.getString("alt");
                            Log.e("monkey", "pratik");


                            //same as above
                            Integer menu_order = object.getInt("menu_order");
                            Integer count = object.getInt("count");
                            Log.e("monkey", "suman");

                            JSONObject _links = object.getJSONObject("_links");
                            Log.e("monkey", "prakash");

                            JSONArray self = _links.getJSONArray("self");
                            Log.e("monkey", "swikriti");

                            String self_href = self.getJSONObject(0).getString("href");
                            Log.e("monkey", "kritik");

                            JSONArray collection = _links.getJSONArray("collection");
                            Log.e("monkey", "binamra");

                            String collection_href = collection.getJSONObject(0).getString("href");
                            //String character = FoodArray.getJSONObject(i).getString("char");
                            //   JSONArray Self = object.getJSONArray("self");
                            //  for (int i = 0; i < Self.length(); i++) {

                            //     String character = Self.getJSONObject(i).getString("href");

                            //   JSONObject status = response.getJSONObject("status");
                            MyData myData= new MyData(id, count, menu_order, parent,image_id,name, slug, description, display,date_created, date_created_gmt, date_modified,date_modified_gmt, src, title, alt, self_href, collection_href);
                            // Log.e("monkey", "prakriti");
                            Log.e("prakash", data_list.size() + "" );
                            data_list.add(myData);
                            flag = 2;
                        }

                    }
                    else {
                        flag = 3;
                    }

                } catch (JSONException e) {

                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);


                mprogressDialog.dismiss();

                if (flag == 1) {
                    Toast.makeText(getContext(), "Server/Network issue", Toast.LENGTH_SHORT).show();

                } else if (flag == 2) {
                    //mAdapter.notifyDataSetChanged();
                    Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
                    mrecyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);

                    GridLayoutManager mGrid = new GridLayoutManager(getContext(),1);
                    mrecyclerView.setLayoutManager(mGrid);
                    mrecyclerView.setHasFixedSize(true);
                    mrecyclerView.setNestedScrollingEnabled(false);
                    Log.e("monkey" , String.valueOf(data_list.size()));
                    MycustomAdapter mAdapter = new MycustomAdapter(getContext(), data_list );
                    mrecyclerView.setAdapter(mAdapter);



                } else if(flag == 3) {
                    Toast.makeText(getContext(), "Invalid credentials", Toast.LENGTH_SHORT).show();
                }


            }

        }

}