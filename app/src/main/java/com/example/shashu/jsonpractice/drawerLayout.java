package com.example.shashu.jsonpractice;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class drawerLayout extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_drawer_layout);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
//            public boolean onNavigationItemSelected(MenuItem menuItem)
//            {
//                //set item as selected to persist higlight
//                menuItem.setChecked(true);
//                //close drawer when item is tapped;
//                mDrawerLayout.closeDrawers();
//                return true;
//            }
//        });
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new home_fragment()).commit();
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(navigationView);

    }
    private void setupDrawerContent(NavigationView navigationView)
    {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                selectedItemDrawer(menuItem);
                return true;
            }
        });
    }
    public void selectedItemDrawer(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_characters:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new characters_fragment()).commit();
                break;
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new home_fragment()).commit();
                break;
            case R.id.nav_trailers:

                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new trailer_fragment()).commit();

                break;
        }
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawerLayout.closeDrawers();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
