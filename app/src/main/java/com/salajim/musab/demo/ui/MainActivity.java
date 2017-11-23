package com.salajim.musab.demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.salajim.musab.demo.R;
import com.salajim.musab.demo.adapters.LogosAdapter;
import com.salajim.musab.demo.models.Demo;
import com.salajim.musab.demo.services.DemoService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private LogosAdapter mAdapter;

    public ArrayList<Demo> mDemos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String demos = intent.getStringExtra("demos");
        getLogos(demos);

    }

    //Inflating Menus
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        inflater.inflate(R.menu.qr_code_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //Menu click listener
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    //This method retrieves the data that will be displayed
    public void getLogos(String demos) {
        final DemoService demoService = new DemoService();
        demoService.logos(demos, new Callback() {

            //This method runs if the request fails
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            //This method runs if the request is successful
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //Log.v("url", "URL");
                mDemos = demoService.processResults(response);

                //We are switching to the main thread using Runnable() method
                MainActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        //We set the adpater and the LayoutManager with the RecyclerView
                        mAdapter = new LogosAdapter(getApplicationContext(), mDemos);
                        mRecyclerView.setAdapter(mAdapter);
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
                        mRecyclerView.setLayoutManager(gridLayoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
