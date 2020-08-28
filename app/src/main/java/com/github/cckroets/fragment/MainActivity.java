package com.github.cckroets.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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

}
