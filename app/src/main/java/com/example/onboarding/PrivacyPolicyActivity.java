package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PrivacyPolicyActivity extends AppCompatActivity {

    ImageView imvBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        //addEvent();
        //linkView();
//    }
//
//    private void linkView() {
//
//        imvBack=findViewById(R.id.imvBack);
//    }
//
//    private void addEvent() {
//        imvBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(PrivacyPolicyActivity.this, PolicyActivity.class));
//            }
//        });
   }
}