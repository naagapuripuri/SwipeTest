package com.example.nagatomo.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.app.ActionBar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {
    android.app.ActionBar.Tab Tab1, Tab2, Tab3;
    MyFragmentStatePagerAdapter mSectionsPagerAdapter;
    ViewPager viewPager;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.pager);
        mSectionsPagerAdapter = new MyFragmentStatePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mSectionsPagerAdapter);
       // viewPager.setAdapter(new MyFragmentStatePagerAdapter(getSupportFragmentManager()));


    }



}
