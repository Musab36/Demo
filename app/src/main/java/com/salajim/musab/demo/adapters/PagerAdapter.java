package com.salajim.musab.demo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.salajim.musab.demo.models.Demo;
import com.salajim.musab.demo.ui.DetailFragment;

import java.util.ArrayList;

/**
 * Created by Musab on 11/23/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Demo> mDenos;

    //A constructor where we set the required FragmentManager and array list of data
    public PagerAdapter(FragmentManager fm, ArrayList<Demo> demos) {
        super(fm);
        mDenos = demos;
    }

    //Returns an instance of the DetailFragment for the data in the position provided as an argument
    @Override
    public Fragment getItem(int position) {
        return DetailFragment.newInstance(mDenos.get(position));
    }

    //Determines how many data are in our Array List. This lets our adapter know how many fragments it must create.
    @Override
    public int getCount() {
        return mDenos.size();
    }

    //Updates the title that appears in the scrolling tabs at the top of the screen
    @Override
    public CharSequence getPageTitle(int position) {
        return mDenos.get(position).getTitle();
    }
}
