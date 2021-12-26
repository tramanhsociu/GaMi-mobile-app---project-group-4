package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import im.crisp.client.ChatActivity;

public class PaymentSuccessActivity extends AppCompatActivity{
    TextView txtTiepTuc,txtTheodoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);
        txtTiepTuc = findViewById(R.id.txtTieptuc);
        txtTheodoi = findViewById(R.id.txtTheodoi);
        txtTiepTuc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentSuccessActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        txtTheodoi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentSuccessActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });
    }
}