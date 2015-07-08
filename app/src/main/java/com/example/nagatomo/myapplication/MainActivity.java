package com.example.nagatomo.myapplication;

import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.app.ActionBar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.app.FragmentTransaction;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener{
    android.app.ActionBar.Tab Tab1, Tab2, Tab3;
    MyFragmentStatePagerAdapter mSectionsPagerAdapter;
    ViewPager viewPager;

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //以下、通常のライブラリのActionBar/及びタブを付ける場合の記述
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        //以下、ViewPagerの為の記述
        viewPager = (ViewPager) findViewById(R.id.pager);
        mSectionsPagerAdapter = new MyFragmentStatePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mSectionsPagerAdapter);
        // viewPager.setAdapter(new MyFragmentStatePagerAdapter(getSupportFragmentManager()));
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


        //以下、NavigationDrawerの為の記述
        String[] list = { "Mercury", "Venus", "Earth", "Mars" };
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer,R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View view) {
                Log.d("ActionBarDrawerToggle", "onDrawerClosed");
            }
            @Override
            public void onDrawerOpened(View drawerView) {

                Log.d("ActionBarDrawerToggle", "onDrawerOpened");
            }
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                Log.d("ActionBarDrawerToggle", "onDrawerSlide : " + slideOffset);
            }
            @Override
            public void onDrawerStateChanged(int newState) {
                Log.d("ActionBarDrawerToggle", "onDrawerStateChanged state : "
                        + newState);
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerList = (ListView)findViewById(R.id.left_drawer);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);
        // アダプターの設定
        mDrawerList.setAdapter(adapter);
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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
    /*    if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }










/*

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggle
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
*/
}






