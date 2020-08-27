package com.github.cckroets.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetFragment extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_sheet, container);
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
        dismiss();
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
