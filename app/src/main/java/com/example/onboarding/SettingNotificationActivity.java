package com.example.onboarding;

import static androidx.constraintlayout.widget.ConstraintSet.INVISIBLE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.SettingNotiFragmentOn;
import com.example.fragment.SettinhNotiFragment;

public class SettingNotificationActivity extends AppCompatActivity {
    ImageView imvBack;
    Switch swtNoti, swtBell;
    TextView txtMyNoti;
    ConstraintLayout Chuong, MyNoti;

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
        swtBell=findViewById(R.id.swtBell);
        txtMyNoti=findViewById(R.id.txtMyNoti);
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
                if(compoundButton.isChecked())
                {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.On, new SettingNotiFragmentOn());
                    fragmentTransaction.commit();
                    Toast.makeText(SettingNotificationActivity.this, "Bật thông báo", Toast.LENGTH_SHORT).show();
                }else {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.On, new SettinhNotiFragment());
                    fragmentTransaction.commit();
                    Toast.makeText(SettingNotificationActivity.this, "Tắt thông báo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}