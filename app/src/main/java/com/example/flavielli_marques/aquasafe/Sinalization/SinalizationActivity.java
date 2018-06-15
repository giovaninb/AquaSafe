package com.example.flavielli_marques.aquasafe.Sinalization;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.flavielli_marques.aquasafe.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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