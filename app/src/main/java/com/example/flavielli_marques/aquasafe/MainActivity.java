package com.example.flavielli_marques.aquasafe;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.flavielli_marques.aquasafe.Checklist.ChecklistActivity;
import com.example.flavielli_marques.aquasafe.Hazard.HazardActivity;
import com.example.flavielli_marques.aquasafe.Immunization.ImmunizationActivity;
import com.example.flavielli_marques.aquasafe.Sinalization.SinalizationActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton hazard_button = (ImageButton) findViewById(R.id.hazard);
        ImageButton checklist_button = (ImageButton) findViewById(R.id.checklist);
        ImageButton signalization_button = (ImageButton) findViewById(R.id.signalization);
        ImageButton immunization_button = (ImageButton) findViewById(R.id.immunization);

        hazard_button.setOnClickListener(click);
        checklist_button.setOnClickListener(click);
        signalization_button.setOnClickListener(click);
        immunization_button.setOnClickListener(click);
    }
    private View.OnClickListener click = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.hazard:
                    String valorTag = v.getTag().toString();
                  //  Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, HazardActivity.class);
                    startActivity(intent);
                    break;

                case R.id.checklist:
                    valorTag = v.getTag().toString();
                    Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, ChecklistActivity.class);
                    startActivity(intent);
                    break;

                case R.id.signalization:
                    valorTag = v.getTag().toString();
                    Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, SinalizationActivity.class);
                    startActivity(intent);
                    break;

                case R.id.immunization:
                    valorTag = v.getTag().toString();
                    Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, ImmunizationActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

}