package com.github.cckroets.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MyFragmentPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {

    public MyFragmentPagerAdapter(@NonNull FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return ChildFragment.newInstance("Child: " + position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "Child " + position;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
