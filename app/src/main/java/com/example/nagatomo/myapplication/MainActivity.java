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

public class MainActivity extends FragmentActivity implements ActionBar.TabListener{
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

        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Actionbarにタブを追加。
            // getPageTitleでタブのタイトルを表示
            actionBar.addTab(actionBar.newTab()
                    .setText(mSectionsPagerAdapter.getPageTitle(i))
                    .setTabListener(this));
        }

        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });


    }



    /**
     * タブを選択した時の処理
     */
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // ここで表示するフラグメントを決定する
        // setCurrentItem で、下記の SectionPagerAdapter の getItem を呼び出し
        viewPager.setCurrentItem(tab.getPosition());
    }

    /**
     * タブの選択が外れた場合の処理
     */
    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    /**
     * タブが2度目以降に選択された場合の処理
     */
    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

}
