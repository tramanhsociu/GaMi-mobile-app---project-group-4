package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ProfileActivity extends AppCompatActivity {
    ImageButton imbSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        imbSetting=findViewById(R.id.imbSetting);
    }

    private void addEvents() {
        imbSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, SettingActivity.class));
            }
        });
    }
}