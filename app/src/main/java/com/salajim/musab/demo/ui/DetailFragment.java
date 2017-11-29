package com.salajim.musab.demo.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.salajim.musab.demo.R;
import com.salajim.musab.demo.models.Demo;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;

    @Bind(R.id.detailImageView) ImageView mDetailImageView;
    @Bind(R.id.detailTitle) TextView mDetailTitle;
    @Bind(R.id.description) TextView mDescription;

    private Demo mDemo;


    // newInstance(), is used instead of a constructor and returns a new instance of DetailFragment
    public static DetailFragment newInstance(Demo demo) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("demo", Parcels.wrap(demo));
        detailFragment.setArguments(args);
        return detailFragment;
    }

    //onCreate(), is called when the fragment is created. Here, we unwrap our data
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDemo = Parcels.unwrap(getArguments().getParcelable("demo"));
    }

    // onCreateView(), this news object is then used to set our ImageView and TextViews
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);

        //Picasso handling the display of images
        Picasso.with(view.getContext())
                .load(mDemo.getUrlToImage())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mDetailImageView);

        mDetailTitle.setText(mDemo.getTitle());
        mDescription.setText("Description \n" + mDemo.getDescription());
        return view;
    }


}
