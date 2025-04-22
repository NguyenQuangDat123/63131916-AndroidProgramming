package com.example.bottom_nav;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Fragment homeFragment = new HomeFragment();
    Fragment searchFragment = new SearchFragment();
    Fragment profileFragment = new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Thêm 3 fragment nhưng chỉ hiện 1
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, homeFragment, "HOME")
                .add(R.id.fragment_container, searchFragment, "SEARCH").hide(searchFragment)
                .add(R.id.fragment_container, profileFragment, "PROFILE").hide(profileFragment)
                .commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            int id = item.getItemId();
            if (id == R.id.nav_home) {
                transaction.show(homeFragment);
                transaction.hide(searchFragment);
                transaction.hide(profileFragment);
            } else if (id == R.id.nav_search) {
                transaction.hide(homeFragment);
                transaction.show(searchFragment);
                transaction.hide(profileFragment);
            } else if (id == R.id.nav_profile) {
                transaction.hide(homeFragment);
                transaction.hide(searchFragment);
                transaction.show(profileFragment);
            }

            transaction.commit();
            return true;
        });
    }
}
