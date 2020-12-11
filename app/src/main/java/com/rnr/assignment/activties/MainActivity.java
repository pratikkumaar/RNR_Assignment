package com.rnr.assignment.activties;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rnr.assignment.R;
import com.rnr.assignment.fragments.HomeFragment;
import com.rnr.assignment.fragments.LeaderboardFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private  Menu menu;
    private boolean doubleBackToExitPressedOnce= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*for setting status bar color white & icons black*/
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.WHITE);

        loadFragment(new HomeFragment());

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        menu = bottomNavigationView.getMenu();
        menu.findItem(R.id.nav_home).setIcon(R.drawable.nav_home_checked);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        loadFragment(new HomeFragment());
                        menuItem.setIcon(R.drawable.nav_home_checked);

                        menu.findItem(R.id.nav_profile).setIcon(R.drawable.nav_profile_unchecked);
                        menu.findItem(R.id.nav_leaderboard).setIcon(R.drawable.nav_leaderboard_unchecked);
                        menu.findItem(R.id.nav_explore).setIcon(R.drawable.nav_explore_unchecked);
                        break;
                    case R.id.nav_profile:
//                        loadFragment(new HomeFragment());
                        menuItem.setIcon(R.drawable.nav_profile_checked);

                        menu.findItem(R.id.nav_home).setIcon(R.drawable.nav_home_unchecked);
                        menu.findItem(R.id.nav_leaderboard).setIcon(R.drawable.nav_leaderboard_unchecked);
                        menu.findItem(R.id.nav_explore).setIcon(R.drawable.nav_explore_unchecked);
                        break;
                    case R.id.nav_leaderboard:
                        loadFragment(new LeaderboardFragment());
                        menuItem.setIcon(R.drawable.nav_leaderboard_checked);

                        menu.findItem(R.id.nav_home).setIcon(R.drawable.nav_home_unchecked);
                        menu.findItem(R.id.nav_profile).setIcon(R.drawable.nav_profile_unchecked);
                        menu.findItem(R.id.nav_explore).setIcon(R.drawable.nav_explore_unchecked);
                        break;
                    case R.id.nav_explore:
//                        loadFragment(new HomeFragment());
                        menuItem.setIcon(R.drawable.nav_explore_checked);

                        menu.findItem(R.id.nav_home).setIcon(R.drawable.nav_home_unchecked);
                        menu.findItem(R.id.nav_profile).setIcon(R.drawable.nav_profile_unchecked);
                        menu.findItem(R.id.nav_leaderboard).setIcon(R.drawable.nav_leaderboard_unchecked);
                        break;


                }

                return true;
            }
        });

    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_main, fragment)
                .commit();

    }


    @Override
    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {

            //additional code
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);

        } else {

            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_main);

            if (fragment instanceof LeaderboardFragment) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_main, new LeaderboardFragment()).addToBackStack("").commit();

            }if (fragment instanceof HomeFragment) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_main, new HomeFragment()).addToBackStack("").commit();

            } else {
                getSupportFragmentManager().popBackStack();

            }


        }
    }

    public void hideNavigation(){
        bottomNavigationView.setVisibility(View.GONE);
    }

    public void visibleNavigation(){
        bottomNavigationView.setVisibility(View.VISIBLE);
    }
}
