package com.example.android.tourguidetokyo;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {
    //Number of tabs/categories
    final int PAGE_COUNT = 4;
    private Context mContext;

    //Constructor
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    //Contains the logic to display the correct fragment in each tab of the pager
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SitesFragment();
        } else if (position == 1) {
            return new MuseumsFragment();
        } else if (position == 2) {
            return new ParksFragment();
        } else {
            return new RestaurantsFragment();
        }
    }

    //Returns the number of pages
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    //Sets the titles of each category
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.sites);
        } else if (position == 1) {
            return mContext.getString(R.string.museums);
        } else if (position == 2) {
            return mContext.getString(R.string.parks);
        } else {
            return mContext.getString(R.string.restaurants);
        }
    }

}

