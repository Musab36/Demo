package com.salajim.musab.demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.salajim.musab.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.signin)
    Button mSigni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ButterKnife.bind(this);

        mSigni.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mSigni) {
            Intent intent = new Intent(AccountActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
