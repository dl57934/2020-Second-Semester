package com.example.addressbook;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends FragmentActivity {
    private MainFragment mainFragment = MainFragment.newInstance("1", "2");
    private InputFragment inputFragment = InputFragment.newInstance("1", "2");
    private AddListFrgment addListFrgment  = AddListFrgment.newInstance("1", "2");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button inputFragmentButton = findViewById(R.id.inputAddressButton);
        Button showFragmentButton = findViewById(R.id.showAddressButton);
        Button mainButton = findViewById(R.id.mainButton);

        mainButton.setOnClickListener( v -> {
            this.changeFragment(mainFragment);
        });
        inputFragmentButton.setOnClickListener( v -> {
            this.changeFragment(inputFragment);
        });
        showFragmentButton.setOnClickListener( v -> {
            this.changeFragment(addListFrgment);
        });

        getSupportFragmentManager().beginTransaction().add(R.id.MainFrameLayout, mainFragment).commit();
    }

    void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.MainFrameLayout, fragment).commit();
    }
}