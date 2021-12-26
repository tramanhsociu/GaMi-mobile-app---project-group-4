package com.example.onboarding;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class NotiFragment extends Fragment{


    ImageButton btnTransfer,btnDropDown;
    TextView txtNoti;
    ConstraintLayout itemSale, itemInfo;
    FrameLayout infolayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_noti, container, false);
        btnTransfer = view.findViewById(R.id.btnTransfer);
        btnDropDown = view.findViewById(R.id.btnDropDown);
        txtNoti = view.findViewById(R.id.txtThongBao);
        itemSale = view.findViewById(R.id.itemSale);
        itemInfo = view.findViewById(R.id.itemInfo);
        infolayout = view.findViewById(R.id.infoOrder);

        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.commit();

        addEvents();
        return view;
    }

    private void addEvents() {
        btnTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layout_notification, new SaleFragment());
                transaction.commit();
                txtNoti.setVisibility(View.GONE);
                itemInfo.setVisibility(View.GONE);
                itemSale.setVisibility(View.GONE);
                infolayout.setVisibility(View.GONE);
            }


        });

        btnDropDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.add(R.id.infoOrder, new InfoOrderFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();


            }
        });

    }

}