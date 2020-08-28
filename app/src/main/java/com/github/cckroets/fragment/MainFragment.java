package com.github.cckroets.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        FragmentActivity activity = getActivity();

        view.findViewById(R.id.navigate_button_with_anim).setOnClickListener(v -> {
            navigateToViewPager(activity, true);
        });
        view.findViewById(R.id.navigate_button_no_anim).setOnClickListener(v -> {
            navigateToViewPager(activity, false);
        });
        return view;
    }

    private void navigateToViewPager(@NonNull FragmentActivity activity, boolean withAnim) {
        new Handler().post(() -> {
            Fragment fragment = new ParentFragment();
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack("parent")
                    .setCustomAnimations(withAnim ? R.anim.fragment_enter : 0,
                                         withAnim ? R.anim.hold : 0,
                                         0,
                                         withAnim ? R.anim.fragment_exit : 0)
                    .replace(android.R.id.content, fragment, "parent")
                    .setPrimaryNavigationFragment(fragment)
                    .commit();
            activity.getSupportFragmentManager().executePendingTransactions();
        });
    }
}
