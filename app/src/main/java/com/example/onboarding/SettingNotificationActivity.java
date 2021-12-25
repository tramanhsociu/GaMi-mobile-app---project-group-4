package com.example.onboarding;

import static androidx.constraintlayout.widget.ConstraintSet.INVISIBLE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
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

    private static String MY_PREFS = "switch_prefs"; //shared preferencs name
    private static String FRAG_STATUS = "frag_status";
    private static String SWITCH_STATUS = "switch_status";

    boolean switch_status;
    boolean frag_status;

    SharedPreferences myPreferences;
    SharedPreferences.Editor myEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_notification);
        linkViews();
        addEvents();

        myPreferences = getSharedPreferences(MY_PREFS, MODE_PRIVATE);
        myEditor = getSharedPreferences(MY_PREFS, MODE_PRIVATE).edit();

        switch_status = myPreferences.getBoolean(SWITCH_STATUS,false);
        frag_status = myPreferences.getBoolean(FRAG_STATUS,false);

        swtNoti.setChecked(switch_status);

        if(frag_status){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.On, new SettingNotiFragmentOn());
            fragmentTransaction.commit();
            Toast.makeText(SettingNotificationActivity.this, "Bật thông báo", Toast.LENGTH_SHORT).show();
        }else{
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.On, new SettinhNotiFragment());
            fragmentTransaction.commit();
            Toast.makeText(SettingNotificationActivity.this, "Tắt thông báo", Toast.LENGTH_SHORT).show();
        }
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

                    myEditor.putBoolean(SWITCH_STATUS,true);
                    myEditor.putBoolean(FRAG_STATUS, true);
                    myEditor.apply();
                    swtNoti.setChecked(true);
                }else {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.On, new SettinhNotiFragment());
                    fragmentTransaction.commit();
                    Toast.makeText(SettingNotificationActivity.this, "Tắt thông báo", Toast.LENGTH_SHORT).show();

                    myEditor.putBoolean(SWITCH_STATUS,false);
                    myEditor.putBoolean(FRAG_STATUS, false);
                    myEditor.apply();
                    swtNoti.setChecked(false);
                }
            }
        });
    }



}