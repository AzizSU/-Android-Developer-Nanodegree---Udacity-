package com.example.android.tourgauide;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class CatAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] {"Restaurants" , "Historical sites", "Parks", "Malls"};

    public CatAdapter(FragmentManager fm) {

        super(fm);
    }
    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        if (position == 0) {
            return new ResFrag();
        } else if (position == 1){
            return new HistoryFrag();
        } else if (position == 2) {
            return new ParksFrag();
        } else {
            return new MallsFrag();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}
