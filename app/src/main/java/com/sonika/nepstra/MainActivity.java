package com.sonika.nepstra;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.widget.SearchView;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.roughike.bottombar.BottomBar;
import com.sonika.nepstra.Navigations.Womens;
import com.sonika.nepstra.adapters.AllProductAdapter;
import com.sonika.nepstra.helpers.MySharedPreference;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    CarouselView carouselview;
    AllProductAdapter allProductAdapter;
    MySharedPreference sharedPreference;
    ArrayAdapter<CharSequence> adapter;
    BottomBar bottomBar;
    ViewPager viewPager;
    SearchView search;
    int[] images = {R.drawable.nepstrab, R.drawable.nepstraa, R.drawable.nepstrac};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
       ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
               this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
     toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        carouselview = (CarouselView) findViewById(R.id.carouselview);
        carouselview.setPageCount(images.length);
        carouselview.setImageListener(imagelistener);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_new_arrival) {
            // Handle the camera action
        } else if (id == R.id.nav_mens) {

        } else if (id == R.id.nav_womens) {
            Intent intent = new Intent(MainActivity.this, Womens.class);
            startActivity(intent);

        } else if (id == R.id.nav_contact) {


        } else if (id == R.id.nav_category) {
            Intent ci = new Intent(MainActivity.this,CategoriesActivity.class );
            startActivity(ci);

        } else if (id == R.id.nav_arts_and_craft) {

        }
        else if (id == R.id.nav_about_us) {
            Intent intentAboutUs = new Intent(this, LoginActivity.class);
            startActivity(intentAboutUs);

        }
        else if (id == R.id.nav_books) {

        }
        else if (id == R.id.nav_jewellry) {

        }
        else if (id == R.id.nav_sports) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);


    }

    ImageListener imagelistener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(images[position]);
        }
    };
  /*  @Override
    public boolean onClose() {
       allProductAdapter.filterData("");
        // expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        allProductAdapter.filterData(query);
        //displayList();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String newText) {
        allProductAdapter.filterData(newText);
        // displayList();
        return false;
    }*/

}