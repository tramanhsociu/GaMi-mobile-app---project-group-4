package com.example.onboarding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.onboarding.AccountDB;

public class onboardingFragment2 extends Fragment {
    FrameLayout btnRegis, btnLogin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_onboarding2,container,false);
       btnRegis=view.findViewById(R.id.btnRegis);
       btnLogin=view.findViewById(R.id.btnLogin);


       btnRegis.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent =new Intent(getActivity(), RegisterActivity.class);
               getActivity().startActivity(intent);
           }
       });
       btnLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getActivity(),LoginActivity.class);
               getActivity().startActivity(intent);
           }
       });
        return view;
    }
}
