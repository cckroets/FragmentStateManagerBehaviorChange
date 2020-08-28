package com.github.cckroets.fragment;

import android.app.Application;

import androidx.fragment.app.FragmentManager;

public class MyApplication extends Application {

    // Logged from FragmentLifecycleCallbacks
    public static final String FRAGMENT_LIFECYCLE_CALLBACKS_TAG = "FragmentCallbacks";

    // Logged from Fragment subclasses before the super call.
    public static final String ACTUAL_FRAGMENT_LIFECYCLE_TAG = "ActualFragment";

    @Override
    public void onCreate() {
        FragmentManager.enableNewStateManager(true);
        super.onCreate();
    }
}
