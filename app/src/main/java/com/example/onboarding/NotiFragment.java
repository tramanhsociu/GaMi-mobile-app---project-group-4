package com.example.onboarding;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class NotiFragment extends Fragment{

    ImageButton btnTransfer,btnDropDown;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_noti, container, false);
        btnTransfer = view.findViewById(R.id.btnTransfer);
        btnDropDown = view.findViewById(R.id.btnDropDown);
        addEvents();
        return view;
    }

    private void addEvents() {
        btnTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent loadNewSale = new Intent(NotificationActivity.this,ItemSale.class);
//                startActivity(loadNewSale);
            }

        });

    }
}