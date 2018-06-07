package com.example.flavielli_marques.aquasafe.Sinalization;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.flavielli_marques.aquasafe.R;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class SinalizationActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinalization);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.signalization);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

    }
}
