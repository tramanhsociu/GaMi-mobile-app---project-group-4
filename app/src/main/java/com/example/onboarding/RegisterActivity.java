package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    TextView txtLogin;
    ImageView imvBack;
    FrameLayout btnRegis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    txtLogin=findViewById(R.id.txtLogin);
    imvBack=findViewById(R.id.imvBack);
    btnRegis=findViewById(R.id.btnRegis);
    txtLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent =new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    });
    imvBack.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent =new Intent(RegisterActivity.this, onboardingFragment2.class);
            startActivity(intent);
        }
    });
    btnRegis.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(RegisterActivity.this, RegisSucessActivity.class);
            startActivity(intent);
        }
    });
    }
}