package com.rohit.serviceexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;


import java.util.ArrayList;

/**
 * Created by igniva-android-14 on 7/12/16.
 */

public class BrowseTourAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments;
    ArrayList<String> text;
   // SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();

    public BrowseTourAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList text) {
        super(fm);
        this.fragments = fragments;
        this.text = text;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return text.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        Log.e("BrowseTourAdapter",position+"");
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


    /*@Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }*/

}
