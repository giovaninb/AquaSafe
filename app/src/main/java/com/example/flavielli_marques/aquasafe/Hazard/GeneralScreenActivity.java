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
            getSupportActionBar().setTitle(R.string.products);
            getSupportActionBar().setLogo(R.drawable.toolbar_products);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = (TextView) findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_products);
            text_hazard = (TextView) findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_products);
            text_control = (TextView) findViewById(R.id.text_control);
            text_control.setText(R.string.control_products);

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
