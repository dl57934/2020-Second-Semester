package com.example.addressbook;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

public class MainActivity extends FragmentActivity {
    private MainFragment mainFragment = MainFragment.newInstance("1", "2");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.MainFrameLayout, mainFragment).commit();
    }

    void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.MainFrameLayout, fragment).addToBackStack(null).commit();
    }
}