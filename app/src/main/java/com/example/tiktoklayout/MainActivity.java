package com.example.tiktoklayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.tiktoklayout.discover.DiscoverFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.navigation_view);
        frameLayout = findViewById(R.id.navigation_view);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                switch (id){
                    case R.id.nav_home:
                        HomeFragment homeFragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,homeFragment).commit();
                        break;

                    case R.id.nav_discover:
                        DiscoverFragment discoverFragment = new DiscoverFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,discoverFragment).commit();
                        break;

                    case R.id.nav_createVideo:
                        break;

                    case R.id.nav_inbox:
                        InBoxFragment inBoxFragment = new InBoxFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,inBoxFragment).commit();
                        break;

                    case R.id.nav_me:
                        ProfileFragment profileFragment = new ProfileFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,profileFragment).commit();
                        break;
                }
                return true;
            }
        });
    }
}
