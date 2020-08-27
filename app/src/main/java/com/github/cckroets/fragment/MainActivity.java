package com.github.cckroets.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().registerFragmentLifecycleCallbacks(new LoggingCallbacks(), true);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            Fragment fragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                                       .replace(android.R.id.content, fragment)
                                       .setPrimaryNavigationFragment(fragment)
                                       .commit();
        }
    }

    private static class LoggingCallbacks extends FragmentManager.FragmentLifecycleCallbacks {

        private static final String TAG = MyApplication.FRAGMENT_LIFECYCLE_CALLBACKS_TAG;

        @Override
        public void onFragmentPreAttached(@NonNull FragmentManager fm, @NonNull Fragment f, @NonNull Context context) {
            Log.i(TAG, "onFragmentPreAttached: " + f);
        }

        @Override
        public void onFragmentAttached(@NonNull FragmentManager fm, @NonNull Fragment f, @NonNull Context context) {
            Log.i(TAG, "onFragmentPreAttached: " + f);
        }

        @Override
        public void onFragmentPreCreated(@NonNull FragmentManager fm,
                                         @NonNull Fragment f,
                                         @Nullable Bundle savedInstanceState) {
            Log.i(TAG, "onFragmentPreAttached: " + f);
        }

        @Override
        public void onFragmentCreated(@NonNull FragmentManager fm,
                                      @NonNull Fragment f,
                                      @Nullable Bundle savedInstanceState) {
            Log.i(TAG, "onFragmentCreated: " + f);
        }

        @Override
        public void onFragmentStarted(@NonNull FragmentManager fm, @NonNull Fragment f) {
            Log.i(TAG, "onFragmentStarted: " + f);
        }

        @Override
        public void onFragmentResumed(@NonNull FragmentManager fm, @NonNull Fragment f) {
            Log.i(TAG, "onFragmentResumed: " + f + ", fm = " + fm);
        }

        @Override
        public void onFragmentPaused(@NonNull FragmentManager fm, @NonNull Fragment f) {
            Log.i(TAG, "onFragmentPaused: " + f);
        }

        @Override
        public void onFragmentStopped(@NonNull FragmentManager fm, @NonNull Fragment f) {
            Log.i(TAG, "onFragmentStopped: " + f);
        }

        @Override
        public void onFragmentDestroyed(@NonNull FragmentManager fm, @NonNull Fragment f) {
            Log.i(TAG, "onFragmentDestroyed: " + f);
        }

        @Override
        public void onFragmentDetached(@NonNull FragmentManager fm, @NonNull Fragment f) {
            Log.i(TAG, "onFragmentDetached: " + f);
        }

        @Override
        public void onFragmentViewCreated(@NonNull FragmentManager fm,
                                          @NonNull Fragment f,
                                          @NonNull View v,
                                          @Nullable Bundle savedInstanceState) {
            Log.i(TAG, "onFragmentViewCreated: " + f);
        }
    }
}
