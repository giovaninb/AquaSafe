package com.example.flavielli_marques.aquasafe.Hazard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.example.flavielli_marques.aquasafe.R;

public class GeneralScreenActivity extends AppCompatActivity {
    TextView text_cause;
    TextView text_hazard;
    TextView text_control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String tag = getIntent().getStringExtra("tagRiscos");


        if (tag.equals("electrocution")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.electrocution);
            getSupportActionBar().setLogo(R.drawable.toolbar_electrocution);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_electrocution);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_electrocution);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_electrocution);

        } else  if (tag.equals("temperature")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.temp);
            getSupportActionBar().setLogo(R.drawable.toolbar_temperature);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_temperature);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_temperature);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_temperature);

        } else  if (tag.equals("noise")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.noise);
            getSupportActionBar().setLogo(R.drawable.toolbar_physicist);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_noise);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_noise);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_noise);

        } else  if (tag.equals("humidity")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.humidity);
            getSupportActionBar().setLogo(R.drawable.toolbar_humidity);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_humidity);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_humidity);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_humidity);

        }else  if (tag.equals("radiation")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.radiation);
            getSupportActionBar().setLogo(R.drawable.toolbar_radiation);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_radiation);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_radiation);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_radiation);

        }else  if (tag.equals("sun")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.sun);
            getSupportActionBar().setLogo(R.drawable.toolbar_sun);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_sun);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_sun);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_sun);

        }else  if (tag.equals("exploding")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.exploding);
            getSupportActionBar().setLogo(R.drawable.toolbar_exploding);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_exploding);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_exploding);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_exploding);

        }else  if (tag.equals("gas")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.gas);
            getSupportActionBar().setLogo(R.drawable.toolbar_gas);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_gas);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_gas);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_gas);

        }else  if (tag.equals("products")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.products_title);
            getSupportActionBar().setLogo(R.drawable.toolbar_products);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_products);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_products);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_products);

        }else  if (tag.equals("zoonoses")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.zoonoses);
            getSupportActionBar().setLogo(R.drawable.toolbar_zoonoses);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_zoonoses);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_zoonoses);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_zoonoses);

        }else  if (tag.equals("venomous_animals")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.venomous_animals);
            getSupportActionBar().setLogo(R.drawable.toolbar_venomous_animals);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_venomous_animals);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_venomous_animals);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_venomous_animals);

        }else  if (tag.equals("waste_pipe")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.waste_pipe);
            getSupportActionBar().setLogo(R.drawable.toolbar_waste_pipe);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_waste_pipe);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_waste_pipe);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_waste_pipe);

        }else  if (tag.equals("residue")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.residue);
            getSupportActionBar().setLogo(R.drawable.toolbar_residue);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_residue);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_residue);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_residue);

        }else  if (tag.equals("posture")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.posture);
            getSupportActionBar().setLogo(R.drawable.toolbar_posture);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_posture);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_posture);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_posture);

        }else  if (tag.equals("night_work")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.night_work);
            getSupportActionBar().setLogo(R.drawable.toolbar_night_work);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_night_work);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_night_work);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_night_work);

        }else  if (tag.equals("heavy")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.heavy);
            getSupportActionBar().setLogo(R.drawable.toolbar_heavy);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_heavy);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_heavy);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_heavy);

        }else  if (tag.equals("psychosocial")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.psychosocial);
            getSupportActionBar().setLogo(R.drawable.toolbar_psychosocial);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_psychosocial);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_psychosocial);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_psychosocial);

        }else  if (tag.equals("excessive_working")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.working);
            getSupportActionBar().setLogo(R.drawable.toolbar_excessive_working);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_excessive_working);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_excessive_working);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_excessive_working);

        }else  if (tag.equals("slide")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.slide);
            getSupportActionBar().setLogo(R.drawable.toolbar_slide);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_slide);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_slide);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_slide);

        }else  if (tag.equals("drowning")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.drowning);
            getSupportActionBar().setLogo(R.drawable.toolbar_drowning);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_drowning);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_drowning);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_drowning);

        }else  if (tag.equals("cut")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.cut);
            getSupportActionBar().setLogo(R.drawable.toolbar_cut);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_cut);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_cut);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_cut);

        }else  if (tag.equals("death")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.death);
            getSupportActionBar().setLogo(R.drawable.toolbar_death);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_death);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_death);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_death);

        }else  if (tag.equals("accident_machine")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.accident_machine);
            getSupportActionBar().setLogo(R.drawable.toolbar_accident_machine);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_accident_machine);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_accident_machine);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_accident_machine);

        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if ( id == android.R.id.home ) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
