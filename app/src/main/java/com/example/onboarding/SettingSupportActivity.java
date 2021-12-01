package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragment.SettingFragment;

import me.relex.circleindicator.CircleIndicator;

public class SettingSupportActivity extends AppCompatActivity {
    ImageView imvBack;
    TextView txtInstruction, txtRefund, txtFollowOrd, txtFreeShip, txtCancelOrd, txtAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_support);
        linkViews();
        addEvents();



    }

    private void linkViews() {
        imvBack=findViewById(R.id.imvBack);
        txtInstruction=findViewById(R.id.txtInstruction);
        txtRefund=findViewById(R.id.txtRefund);
        txtFollowOrd=findViewById(R.id.txtFollowOrd);
        txtFreeShip=findViewById(R.id.txtFreeShip);
        txtCancelOrd=findViewById(R.id.txtCancelOrd);
        txtAccount=findViewById(R.id.txtAccount);
    }

    private void addEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingSupportActivity.this, SettingActivity.class));
            }
        });
        txtInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SettingFragment());
            }
        });
        txtRefund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hoàn tiền
            }
        });
        txtFollowOrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //theo dõi đơn
            }
        });
        txtFreeShip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mã freeship
            }
        });
        txtCancelOrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hủy đơn
            }
        });
        txtAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tk bị khóa
            }
        });
    }

    private void replaceFragment(SettingFragment settingFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.post_support, settingFragment);
        fragmentTransaction.commit();
    }
}