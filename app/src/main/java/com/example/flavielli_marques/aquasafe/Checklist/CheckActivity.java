package com.example.flavielli_marques.aquasafe.Checklist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.flavielli_marques.aquasafe.R;

public class CheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(R.string.checklist);
        setContentView(R.layout.activity_check);
    }
}
