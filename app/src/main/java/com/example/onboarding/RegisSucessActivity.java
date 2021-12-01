package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class RegisSucessActivity extends AppCompatActivity {
    ImageView imvBack;
    FrameLayout btnGetStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis_sucess);
        linkViews();
        addEvents();

    }

    private void linkViews() {
        imvBack=findViewById(R.id.imvBack);
        btnGetStart=findViewById(R.id.btnGetStart);
    }

    private void addEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisSucessActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
//        btnGetStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(RegisSucessActivity.this, HomeActivity.class));
//            }
//        });
    }
}