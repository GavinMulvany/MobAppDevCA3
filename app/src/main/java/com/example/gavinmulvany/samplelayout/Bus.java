package com.example.gavinmulvany.samplelayout;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Bus extends AppCompatActivity {

    private TabLayout tablelayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        tablelayout = (TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //adding the fragments
        adapter.AaddFragment(new FragmentBus(), "Dublin Bus");
        adapter.AaddFragment(new FragmentSe(), "Swords Express");
        //setting up
        viewPager.setAdapter(adapter);
        tablelayout.setupWithViewPager(viewPager);




    }
}
