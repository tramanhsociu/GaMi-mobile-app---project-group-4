package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class NotificationActivity extends AppCompatActivity {

    ImageButton btnTransfer,btnDropDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnTransfer = findViewById(R.id.btnTransfer);
        btnDropDown = findViewById(R.id.btnDropDown);
    }

    private void addEvents() {
        btnTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loadNewSale = new Intent(NotificationActivity.this,ItemSale.class);
                startActivity(loadNewSale);
            }

        });
    }
}