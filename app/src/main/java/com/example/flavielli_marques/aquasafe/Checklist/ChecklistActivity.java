package com.example.flavielli_marques.aquasafe.Checklist;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.flavielli_marques.aquasafe.Hazard.AccidentActivity;
import com.example.flavielli_marques.aquasafe.Hazard.BiologicalActivity;
import com.example.flavielli_marques.aquasafe.Hazard.GeneralScreenActivity;
import com.example.flavielli_marques.aquasafe.R;

import static android.view.View.*;


public class ChecklistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.app_name);

        android.support.v4.app.Fragment fragment = new IntroductionFragment();
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_fragment, fragment);
        transaction.commit();
    }

}
