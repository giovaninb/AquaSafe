package com.example.flavielli_marques.aquasafe.Checklist;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.flavielli_marques.aquasafe.R;

import java.util.ArrayList;


public class CheckActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(R.string.checklist);
        setContentView(R.layout.activity_check);



        int[] resultados = getIntent().getIntArrayExtra("resultado");
        if (resultados == null) {
            android.support.v4.app.Fragment fragment = new ChecklistFragment();
            android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_frame, fragment);
            transaction.commit();

        } else {
            FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
            android.support.v4.app.Fragment resultFragment =ResultFragment.newInstance(resultados);
            fragment.add(R.id.content_frame, resultFragment);
            fragment.commit();

        }
    }

}
