package com.example.nagatomo.myapplication;

/**
 * Created by Nagatomo on 2015/07/06.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentStatePagerAdapter extends FragmentPagerAdapter {
    public MyFragmentStatePagerAdapter(FragmentManager fm) { super(fm); }

    @Override public Fragment getItem(int i) {
        switch(i){
            case 0: return new Fragment0();
            case 1: return new Fragment1();
            default: return new Fragment2();
        }
    }


    @Override public int getCount() { return 3; }

    @Override public CharSequence getPageTitle(int position) { return "Page " + position; }


}