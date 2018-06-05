package com.example.flavielli_marques.aquasafe.Sinalization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.flavielli_marques.aquasafe.R;

public class SinalizationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinalization);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.signalization);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
