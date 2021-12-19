package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class CartActivity extends AppCompatActivity implements PaymentResultListener {
    Button btnShop;
    TextView txtTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        linkViews();
        addEvents();

        Checkout.preload(CartActivity.this);
    }

    private void linkViews() {
        btnShop=findViewById(R.id.btnShop);
        txtTotal=findViewById(R.id.txtTotal);
    }

    private void addEvents() {
        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPayment(Integer.parseInt(txtTotal.getText().toString()));
            }
        });
    }
    public void startPayment(int Amount) {
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_MyDwhAOJr8uZqe");
        try{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "GaMi");
            jsonObject.put("description", "Giao dịch nhanh chóng với RazorPay");
         //   jsonObject.put("image", "");
            jsonObject.put("theme.color", "#FF8A75");
            jsonObject.put("currency", "VND");
            jsonObject.put("amount", Amount);

            JSONObject retryObj=new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count",4);

            jsonObject.put("retry", retryObj);

            checkout.open(CartActivity.this, retryObj);

        }catch (Exception e){
            Toast.makeText(CartActivity.this, "Có gì đó không ổn", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(CartActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(CartActivity.this, "Error: "+ s, Toast.LENGTH_SHORT).show();
    }
}