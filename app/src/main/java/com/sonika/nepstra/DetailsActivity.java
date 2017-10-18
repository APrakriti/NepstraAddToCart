package com.sonika.nepstra;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sonika.nepstra.helpers.MySharedPreference;
import com.sonika.nepstra.helpers.OrderHelper;
import com.sonika.nepstra.pojo.AllProducts;
import com.sonika.nepstra.pojo.OrderedProducts_pojo;


public class DetailsActivity extends AppCompatActivity {
    ImageView imageview_details;
    Button addToCart;
    TextView textView_name_details, textView_desc_details, textView_price_details;
    private MySharedPreference sharedPreference;
    Gson gson;
    OrderedProducts_pojo pojo;
    private int cartProductNumber = 0;
    OrderHelper dbHelper;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        dbHelper = new OrderHelper(DetailsActivity.this);
        sharedPreference = new MySharedPreference(DetailsActivity.this);
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();

        final AllProducts allProducts = (AllProducts) getIntent().getSerializableExtra("hello");

        imageview_details = (ImageView) findViewById(R.id.image);
        textView_name_details = (TextView) findViewById(R.id.txt_name);
        textView_desc_details = (TextView) findViewById(R.id.txt_desc);
        textView_price_details = (TextView) findViewById(R.id.txt_price);
        // addToCart = (Button) findViewById(R.id.buttonCart);

        Glide.with(DetailsActivity.this).load(allProducts.getI_src()).into(imageview_details);
        textView_desc_details.setText(allProducts.getDescription());
        textView_price_details.setText(allProducts.getPrice());
        textView_name_details.setText(allProducts.getName());







      /* addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //increase product count
                String productsFromCart = sharedPreference.retrieveProductFromCart();
                if(productsFromCart.equals("")){
                    List<AllProducts> cartProductList = new ArrayList<AllProducts>();
                    cartProductList.add(singleProduct);
                    String cartValue = gson.toJson(cartProductList);
                    sharedPreference.addProductToTheCart(cartValue);
                    cartProductNumber = cartProductList.size();
                }else{
                    String productsInCart = sharedPreference.retrieveProductFromCart();
                    AllProducts[] storedProducts = gson.fromJson(productsInCart, AllProducts[].class);

                    List<AllProducts> allNewProduct = convertObjectArrayToListObject(storedProducts);
                    allNewProduct.add(singleProduct);
                    String addAndStoreNewProduct = gson.toJson(allNewProduct);
                    sharedPreference.addProductToTheCart(addAndStoreNewProduct);
                    cartProductNumber = allNewProduct.size();
                }
                sharedPreference.addProductCount(cartProductNumber);
                invalidateCart();
            }
        });
    }
    private List<AllProducts> convertObjectArrayToListObject(AllProducts[] allProducts){
        List<AllProducts> mProduct = new ArrayList<AllProducts>();
        Collections.addAll(mProduct, allProducts);
        return mProduct;
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        MenuItem menuItem = menu.findItem(R.id.action_shop);
//        int mCount = sharedPreference.retrieveProductCount();
//        menuItem.setIcon(buildCounterDrawable(mCount, R.drawable.cart));
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        final int id = item.getItemId();
//
//        if (id == R.id.action_shop)
//        {
//            Intent checkoutIntent = new Intent(DetailsActivity.this, OrderedProducts.class);
//            startActivity(checkoutIntent);
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    private Drawable buildCounterDrawable(int count, int backgroundImageId) {
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View view = inflater.inflate(R.layout.cart, null);
//        view.setBackgroundResource(backgroundImageId);
//
//        if (count == 0) {
//            View counterTextPanel = view.findViewById(R.id.counterValuePanel);
//            counterTextPanel.setVisibility(View.GONE);
//        } else {
//            TextView textView = (TextView) view.findViewById(R.id.count);
//            textView.setText("" + count);
//        }
//
//        view.measure(
//                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
//                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
//        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
//
//        view.setDrawingCacheEnabled(true);
//        view.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
//        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
//        view.setDrawingCacheEnabled(false);
//
//        return new BitmapDrawable(getResources(), bitmap);
//    }
    private void invalidateCart() {
        invalidateOptionsMenu();
    }
}

*/
    }
}