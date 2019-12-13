package com.ben.duan1_shop;

import android.os.Bundle;
import android.view.MenuItem;

import com.ben.duan1_shop.Fragment.Home_Fragment;
import com.ben.duan1_shop.Fragment.lichsu_fragment;
import com.ben.duan1_shop.Fragment.use_fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class TrangchuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new Home_Fragment()).commit();
        }
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);



    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.nav_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new Home_Fragment()).commit();
                    return true;
                case R.id.nav_history:
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new lichsu_fragment()).commit();
                    return  true;
                case  R.id.nav_user:
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new use_fragment()).commit();
                    return  true;


            }
            return false;
        }
    };

}
