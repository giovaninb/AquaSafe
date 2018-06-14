package com.example.flavielli_marques.aquasafe.About;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.flavielli_marques.aquasafe.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.about);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
