package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class SettingNotificationActivity extends AppCompatActivity {
    ImageView imvBack;
    Switch swtNoti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_notification);
        linkViews();
        addEvents();

        
    }

    private void linkViews() {
        imvBack=findViewById(R.id.imvBack);
        swtNoti=findViewById(R.id.swtNoti);
    }


    private void addEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingNotificationActivity.this, SettingActivity.class));
            }
        });
        swtNoti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(SettingNotificationActivity.this, "Bật thông báo", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(SettingNotificationActivity.this, "Tắt thông báo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}