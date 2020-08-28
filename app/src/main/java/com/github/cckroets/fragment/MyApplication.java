package com.github.cckroets.fragment;

import android.app.Application;

import androidx.fragment.app.FragmentManager;

/**
 * When the new State Manager behavior is enabled, the order of fragment lifecycle events
 * as seen by FragmentLifecycleCallbacks is different. Specifically the order of a parent
 * Fragment's onResume() call is observed after the child's onResume() call.
 *
 * Below are the logs from {@link LoggingCallbacks} with both behaviors:
 *
 * enableNewStateManager(true):                 enableNewStateManager(false):
 *
 * onFragmentPreAttached: ParentFragment        onFragmentPreAttached: ParentFragment
 * onFragmentCreated: ParentFragment            onFragmentCreated: ParentFragment
 * onFragmentViewCreated: ParentFragment        onFragmentViewCreated: ParentFragment
 * onFragmentStarted: ParentFragment            onFragmentStarted: ParentFragment
 * onFragmentPreAttached: ChildFragment{1}      onFragmentResumed: ParentFragment
 * onFragmentCreated: ChildFragment{1}          onFragmentPreAttached: ChildFragment{1}
 * onFragmentViewCreated: ChildFragment{1}      onFragmentCreated: ChildFragment{1}
 * onFragmentStarted: ChildFragment{1}          onFragmentPreAttached: ChildFragment{2}
 * onFragmentPreAttached: ChildFragment{2}      onFragmentCreated: ChildFragment{2}
 * onFragmentCreated: ChildFragment{2}          onFragmentViewCreated: ChildFragment{1}
 * onFragmentViewCreated: ChildFragment{2}      onFragmentStarted: ChildFragment{1}
 * onFragmentStarted: ChildFragment{2}          onFragmentResumed: ChildFragment{1}
 * onFragmentResumed: ChildFragment{1}          onFragmentViewCreated: ChildFragment{2}
 * onFragmentResumed: ChildFragment{2}          onFragmentStarted: ChildFragment{2}
 * onFragmentResumed: ParentFragment            onFragmentResumed: ChildFragment{2}
 */
public class MyApplication extends Application {

    // Logged from FragmentLifecycleCallbacks
    public static final String FRAGMENT_LIFECYCLE_CALLBACKS_TAG = "FragmentCallbacks";

    // Logged from Fragment subclasses before the super call.
    public static final String ACTUAL_FRAGMENT_LIFECYCLE_TAG = "ActualFragment";

    @Override
    public void onCreate() {
        // Toggle this for different behavior
        FragmentManager.enableNewStateManager(true);
        super.onCreate();
    }
}
