package com.shop.android.shopgreen;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
// THis code is working with drawer menu
    // create  amember variable for drawerlayout
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
       // create two string resources
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_open);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // On rotation to save the instance
        if(savedInstanceState == null) {
            // The foll ,eans we will open the MessageFragment immediately when we opne the app
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();
            navigationView.setCheckedItem(R.id.drawer_login);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.drawer_login:
                 getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new LoginFragment()).commit();
                 break;
            case R.id.drawer_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
                break;
            case R.id.drawer_address:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AdressFragment()).commit();
                break;
            case R.id.drawer_myorders:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MyOrdersFragment()).commit();
                break;
            case R.id.drawer_contactus:
                Toast.makeText(this,"Contact us ",Toast.LENGTH_LONG).show();
                break;
            case R.id.drawer_rateus:
                Toast.makeText(this,"Rate us ",Toast.LENGTH_LONG).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }
}
