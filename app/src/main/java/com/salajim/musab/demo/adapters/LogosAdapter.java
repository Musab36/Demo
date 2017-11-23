package com.salajim.musab.demo.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.salajim.musab.demo.R;
import com.salajim.musab.demo.models.Demo;
import com.salajim.musab.demo.ui.DetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Musab on 11/22/2017.
 */

public class LogosAdapter extends RecyclerView.Adapter<LogosAdapter.LogosViewHolder> {
    private static final int MAX_WIDTH = 500;
    private static final int MAX_HEIGHT = 300;

    private ArrayList<Demo> mDemos = new ArrayList<>();
    private Context mContext;

    public LogosAdapter(Context context, ArrayList<Demo> demos) {
        mContext = context;
        mDemos = demos;
    }

    // onCreateViewHolder method which inflates the layout, and creates the ViewHolder object required from the adapter
    @Override
    public LogosAdapter.LogosViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.logos, parent, false);
        LogosViewHolder viewHolder = new LogosViewHolder(view);
        return viewHolder;
    }

    // onBindViewHolder method which updates the contents of the ItemView to reflect the news in the given position
    @Override
    public void onBindViewHolder(LogosAdapter.LogosViewHolder holder, int position) {
        holder.bindLogos(mDemos.get(position));
    }

    // getItemCount method which sets the number of items the adapter will display
    @Override
    public int getItemCount() {
        return mDemos.size();
    }

    // viewHolder class as an inner/nested class
    public class LogosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @Bind(R.id.logosImageView) ImageView mLogosImageView;
        @Bind(R.id.titleTextView) TextView mTitle;

        private Context mContext;

        public LogosViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);

        }

        public void bindLogos(Demo demo) {
            Picasso.with(mContext)
                    .load(demo.getUrlToImage())
                    .resize(MAX_WIDTH, MAX_HEIGHT)
                    .centerCrop()
                    .into(mLogosImageView);

            mTitle.setText(demo.getTitle());
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("demos", Parcels.wrap(mDemos));
            mContext.startActivity(intent);
        }

    }
}
