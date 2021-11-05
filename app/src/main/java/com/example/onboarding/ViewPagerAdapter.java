package com.example.onboarding;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new onboardingFragment();
            case 1:
                return new onboardingFragment1();
            case 2:
                return new onboardingFragment2();
            default:
                return new onboardingFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
