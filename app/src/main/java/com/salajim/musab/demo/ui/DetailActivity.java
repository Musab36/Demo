package com.salajim.musab.demo.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.salajim.musab.demo.R;
import com.salajim.musab.demo.adapters.PagerAdapter;
import com.salajim.musab.demo.models.Demo;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager)
    ViewPager mViewPager;
    private PagerAdapter adapterViewPager;
    ArrayList<Demo> mDemos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        //We pull out our ArrayList<Demo> Parcelable using the unwrap() method
        mDemos = Parcels.unwrap(getIntent().getParcelableExtra("demos"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        //We setup the Pager Adapter
        adapterViewPager = new PagerAdapter(getSupportFragmentManager(), mDemos);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
