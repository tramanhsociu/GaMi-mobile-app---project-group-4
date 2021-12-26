package com.example.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;

public class onboardingFragment extends Fragment {
    LottieAnimationView Swipe;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_onboarding,container,false);
        Swipe = view.findViewById(R.id.Swipe);
//        Swipe.animate().translationY(2000).setDuration(2700).setStartDelay(2900);

        return view;
    }

}
