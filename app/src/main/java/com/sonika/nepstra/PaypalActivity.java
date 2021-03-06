package com.sonika.nepstra;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import java.math.BigDecimal;

import android.content.SharedPreferences;
import android.nfc.Tag;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;
import com.sonika.nepstra.Configeration.PayPalConfig;
import com.sonika.nepstra.helpers.OrderHelper;
import com.sonika.nepstra.listener.ListViewListener;

import org.json.JSONException;

import static android.R.attr.data;


public class PaypalActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = PaypalActivity.class.getSimpleName();
    private double totalCostPrice;


    public static final String PAYPAL_CLIENT_ID = "AS5RbUXqNs0aUxf7jImoL1bWCby07Mld2RCaQxCxIopF4i6ghY9ZW8JNvMo0C945-doxWqR0zdJOxyRT";
    public static final int PAYPAL_REQUEST_CODE = 123;
    private Button buttonPay;
    String totalamt;

    private static PayPalConfiguration config = new PayPalConfiguration()
            // sandbox (ENVIRONMENT_SANDBOX)
            // or live (ENVIRONMENT_PRODUCTION)
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(PAYPAL_CLIENT_ID);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paypal);
//     totalCostPrice = getIntent().getExtras().getDouble("TOTAL_PRICE");
//     Log.d(TAG, "Price Prakriti " + totalCostPrice);
        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(intent);
////


        buttonPay = (Button) findViewById(R.id.buttonPay);
        buttonPay.setOnClickListener(this);
        assert buttonPay != null;
        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialization();

            }
        });

    }

    @Override
    public void onDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //If the result is from paypal
        if (requestCode == PAYPAL_REQUEST_CODE) {

            //If the result is OK i.e. user has not canceled the payment
            if (resultCode == Activity.RESULT_OK) {
                //Getting the payment confirmation
                PaymentConfirmation confirm = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);

                //if confirmation is not null
                if (confirm != null) {
                    try {
                        //Getting the payment details

                        new AlertDialog.Builder(PaypalActivity.this)
                                .setTitle("Success")
                                .setMessage(confirm.toJSONObject().toString(4)+"\n"+confirm.getPayment().toJSONObject().toString(4))
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // continue with delete
                                    }
                                })
                                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // do nothing
                                    }
                                })
                                .setIcon(android.R.drawable.ic_dialog_info)
                                .show();

                    } catch (JSONException e) {
                        Log.e("paymentExample", "an extremely unlikely failure occurred: ", e);
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.i("paymentExample", "The user canceled.");
            } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
                Log.i("paymentExample", "An invalid Payment or PayPalConfiguration was submitted. Please see the docs.");
            }
        }
    }


    private void initialization(){
        SharedPreferences sharedPreferences = getSharedPreferences("USER_LOGIN",0);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        totalamt = sharedPreferences.getString("total_amount", null);
        Log.e(TAG, "Totall kjhvsdjhvdjkvhdfs:"  +totalamt);
        editor.commit();
//
       PayPalPayment payment = new PayPalPayment(new BigDecimal(String.valueOf(totalamt)), "USD", "Total Cost",
                PayPalPayment.PAYMENT_INTENT_SALE);

        //Creating a paypalpayment


        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);

        //Starting the intent activity for result
        //the request code will be used on the method onActivityResult
        startActivityForResult(intent, PAYPAL_REQUEST_CODE);
    }

    @Override
    public void onClick(View view) {
        initialization();

    }

}

