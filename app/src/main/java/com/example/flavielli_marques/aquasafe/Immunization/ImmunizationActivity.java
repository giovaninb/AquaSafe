package com.example.flavielli_marques.aquasafe.Immunization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.flavielli_marques.aquasafe.R;

public class ImmunizationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immunization);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.immunization);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
