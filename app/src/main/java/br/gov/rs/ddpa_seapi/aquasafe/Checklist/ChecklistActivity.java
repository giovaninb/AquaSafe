package br.gov.rs.ddpa_seapi.aquasafe.Checklist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import br.gov.rs.ddpa_seapi.aquasafe.Hazard.MainSpecificActivity;
import br.gov.rs.ddpa_seapi.aquasafe.MainActivity;
import br.gov.rs.ddpa_seapi.aquasafe.R;


public class ChecklistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.general_checklist);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container_fragment, new IntroductionFragment());
        ft.commit();


    }
}
