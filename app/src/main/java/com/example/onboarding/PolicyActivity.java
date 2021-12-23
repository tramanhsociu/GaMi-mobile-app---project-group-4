package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;

public class PolicyActivity extends AppCompatActivity {
    ImageView imvBack;
    View ly_PrivacyPolicy, ly_DeliveryPolicy, ly_ExchangePolicy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);


        linkView();
        addEvent();
    }

    private void linkView() {
        ly_PrivacyPolicy = findViewById(R.id.ly_PrivacyPolicy);
        ly_DeliveryPolicy = findViewById(R.id.ly_DeliveryPolicy);
        ly_ExchangePolicy = findViewById(R.id.ly_ExchangePolicy);
        imvBack=findViewById(R.id.imvBack);
    }

    private void addEvent() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//             replaceFragment(new ProfileFragment());
                startActivity(new Intent(PolicyActivity.this, HomeActivity.class));

            }
        });
        ly_PrivacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PolicyActivity.this, PrivacyPolicyActivity.class));

            }
        });
        ly_DeliveryPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PolicyActivity.this, DeliveryPolicy.class));
            }
        });
        ly_ExchangePolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PolicyActivity.this, ExchangePolicyActivity.class));
            }
        });
    }

}