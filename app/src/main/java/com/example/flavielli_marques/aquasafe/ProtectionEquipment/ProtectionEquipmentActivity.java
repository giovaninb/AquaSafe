package com.example.flavielli_marques.aquasafe.ProtectionEquipment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.flavielli_marques.aquasafe.R;

public class ProtectionEquipmentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protection_equipment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.equipment);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}