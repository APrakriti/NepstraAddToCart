//package com.sonika.nepstra;
//
//import android.annotation.TargetApi;
//import android.app.SearchManager;
//import android.content.Context;
//import android.database.Cursor;
//import android.os.Build;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.SearchView;
//import android.util.Log;
//import android.view.Menu;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import com.sonika.nepstra.adapters.SearchAdapter;
//import com.sonika.nepstra.adapters.WomenAdapter;
//import com.sonika.nepstra.helpers.SearchHelper;
//import com.sonika.nepstra.helpers.WomenHelper;
//import com.sonika.nepstra.pojo.SearchPojo;
//import com.sonika.nepstra.pojo.WomenProducts_pojo;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Search extends AppCompatActivity {
//    ListView lv;
//    SearchHelper searchHelper;
//    SearchAdapter searchAdapter;
//    Cursor cursor;
//    private final static String TAG= MainActivity.class.getName().toString();
//    List<SearchPojo> searchlist = new ArrayList<>();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);
//        searchHelper= new SearchHelper(this);
//        lv = (ListView) findViewById(R.id.search);
//        showSearchProducts();
//    }
//
//    private void showSearchProducts() {
//        searchlist = searchHelper.getSearch();
//        for (int i = 0; i < searchlist.size(); i++) {
//            final SearchPojo info =searchlist.get(i);
//           searchAdapter= new SearchAdapter(this, searchlist, R.layout.search_list);
//            lv.setAdapter(searchAdapter);
//            lv.deferNotifyDataSetChanged();
//        }
//    }
//
//
// /*   @Override
//    public void onResume(){
//        super.onResume();
//
//    }
//
//    @Override
//    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.menu_search, menu);
//
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//            SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//            SearchView search = (SearchView) menu.findItem(R.id.search).getActionView();
//            search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));
//
//            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//
//                @Override
//                public boolean onQueryTextSubmit(String s) {
//                    Log.d(TAG, "onQueryTextSubmit ");
//                    cursor=studentRepo.getStudentListByKeyword(s);
//                    if (cursor==null){
//                        Toast.makeText(Search.this,"No records found!",Toast.LENGTH_LONG).show();
//                    }else{
//                        Toast.makeText(Search.this, cursor.getCount() + " records found!",Toast.LENGTH_LONG).show();
//                    }
//                    searchAdapter.swapCursor(cursor);
//
//                    return false;
//                }
//
//                @Override
//                public boolean onQueryTextChange(String s) {
//                    Log.d(TAG, "onQueryTextChange ");
//                    cursor=studentRepo.getStudentListByKeyword(s);
//                    if (cursor!=null){
//                        searchAdapter.swapCursor(cursor);
//                    }
//                    return false;
//                }
//
//            });
//
//        }
//
//        return true;
//
//    }*/
//
//}
