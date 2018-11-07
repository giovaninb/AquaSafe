package br.gov.rs.ddpa_seapi.aquasafe.Hazard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import br.gov.rs.ddpa_seapi.aquasafe.R;


public class GeneralScreenActivity extends AppCompatActivity {
    TextView text_cause;
    TextView text_hazard;
    TextView text_control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_screen);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String tag = getIntent().getStringExtra("tagRiscos");


        if (tag.equals("electrocution")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.electrocution);
        //    getSupportActionBar().setLogo(R.drawable.toolbar_electrocution);
        //    getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause =  findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_electrocution);
            text_hazard = findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_electrocution);
            text_control =  findViewById(R.id.text_control);
            text_control.setText(R.string.control_electrocution);

        } else  if (tag.equals("noise")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.noise);
         //   getSupportActionBar().setLogo(R.drawable.toolbar_noise);
         //   getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause =  findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_noise);
            text_hazard = findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_noise);
            text_control = findViewById(R.id.text_control);
            text_control.setText(R.string.control_noise);

        } else  if (tag.equals("solar_radiation")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.solar_radiation);
         //   getSupportActionBar().setLogo(R.drawable.toolbar_physicist);
          //  getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause =  findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_solar_radiation);
            text_hazard =  findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_solar_radiation);
            text_control =  findViewById(R.id.text_control);
            text_control.setText(R.string.control_solar_radiation);

        } else  if (tag.equals("fire_explosion")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.fire_explosion);
        //    getSupportActionBar().setLogo(R.drawable.toolbar_humidity);
        //    getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_fire_explosion);
            text_hazard =  findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_fire_explosion);
            text_control = findViewById(R.id.text_control);
            text_control.setText(R.string.control_fire_explosion);

        }else  if (tag.equals("extreme_temperatures")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.extreme_temperatures);
         //   getSupportActionBar().setLogo(R.drawable.toolbar_radiation);
         //   getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause =  findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_extreme_temperatures);
            text_hazard = findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_extreme_temperatures);
            text_control =  findViewById(R.id.text_control);
            text_control.setText(R.string.control_extreme_temperatures);

        }else  if (tag.equals("humidity")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.humidity);
        //    getSupportActionBar().setLogo(R.drawable.toolbar_exploding);
        //    getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause =  findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_humidity);
            text_hazard =  findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_humidity);
            text_control = findViewById(R.id.text_control);
            text_control.setText(R.string.control_humidity);

        }else  if (tag.equals("dust_gases")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.dust_gases);
         //   getSupportActionBar().setLogo(R.drawable.toolbar_gas);
         //   getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause =  findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_dust_gases);
            text_hazard =  findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_dust_gases);
            text_control =findViewById(R.id.text_control);
            text_control.setText(R.string.control_dust_gases);

        }else  if (tag.equals("products")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.products);
         //   getSupportActionBar().setLogo(R.drawable.toolbar_products);
         //   getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause =  findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_products);
            text_hazard =  findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_products);
            text_control =  findViewById(R.id.text_control);
            text_control.setText(R.string.control_products);

        }else  if (tag.equals("resistance")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.resistance);
         //   getSupportActionBar().setLogo(R.drawable.toolbar_zoonoses);
         //   getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause =  findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_resistance);
            text_hazard =  findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_resistance);
            text_control =  findViewById(R.id.text_control);
            text_control.setText(R.string.control_resistance);

        }else  if (tag.equals("zoonoses")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.zoonoses);
        //    getSupportActionBar().setLogo(R.drawable.toolbar_venomous_animals);
         //   getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause =  findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_zoonoses);
            text_hazard =  findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_zoonoses);
            text_control =  findViewById(R.id.text_control);
            text_control.setText(R.string.control_zoonoses);

        }else  if (tag.equals("animals")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.animals);
        //    getSupportActionBar().setLogo(R.drawable.toolbar_waste_pipe);
         //   getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause =  findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_animals);
            text_hazard = findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_animals);
            text_control = findViewById(R.id.text_control);
            text_control.setText(R.string.control_animals);

        }else  if (tag.equals("excessive_physical_effort")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.excessive_physical_effort);
        //    getSupportActionBar().setLogo(R.drawable.toolbar_residue);
       //     getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause =  findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_excessive_physical_effort);
            text_hazard = findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_excessive_physical_effort);
            text_control =  findViewById(R.id.text_control);
            text_control.setText(R.string.control_excessive_physical_effort);

        }else  if (tag.equals("psychosocial")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.psychosocial);
        //    getSupportActionBar().setLogo(R.drawable.toolbar_injuries);
        //    getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause =  findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_psychosocial);
            text_hazard =  findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_psychosocial);
            text_control =findViewById(R.id.text_control);
            text_control.setText(R.string.control_psychosocial);

        }else  if (tag.equals("excessive_workday")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.excessive_workday);
       //     getSupportActionBar().setLogo(R.drawable.toolbar_night_work);
      //      getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause =  findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_excessive_workday);
            text_hazard =  findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_excessive_workday);
            text_control = findViewById(R.id.text_control);
            text_control.setText(R.string.control_excessive_workday);

        }else  if (tag.equals("night_work")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.night_work);
       //     getSupportActionBar().setLogo(R.drawable.toolbar_heavy);
         //   getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause =  findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_night_work);
            text_hazard =  findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_night_work);
            text_control = findViewById(R.id.text_control);
            text_control.setText(R.string.control_night_work);

        }else  if (tag.equals("machinery")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.machinery);
        //    getSupportActionBar().setLogo(R.drawable.toolbar_psychosocial);
         //   getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause = findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_machinery);
            text_hazard = findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_machinery);
            text_control =  findViewById(R.id.text_control);
            text_control.setText(R.string.control_machinery);

        }else  if (tag.equals("slips")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.slips);
        //    getSupportActionBar().setLogo(R.drawable.toolbar_excessive_working);
        //    getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause =  findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_slips);
            text_hazard =  findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_slips);
            text_control = findViewById(R.id.text_control);
            text_control.setText(R.string.control_slips);

        }else  if (tag.equals("drowning")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.drowning);
        //    getSupportActionBar().setLogo(R.drawable.toolbar_slide);
        //    getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause =  findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_drowning);
            text_hazard =  findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_drowning);
            text_control = findViewById(R.id.text_control);
            text_control.setText(R.string.control_drowning);

        }else  if (tag.equals("cutting_drilling")) {
            View viewById = findViewById(R.id.content_general_screen);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.cutting_drilling);
        //    getSupportActionBar().setLogo(R.drawable.toolbar_slide);
        //    getSupportActionBar().setDisplayUseLogoEnabled(true);
            text_cause =  findViewById(R.id.text_cause);
            text_cause.setText(R.string.cause_cutting_drilling);
            text_hazard =  findViewById(R.id.text_hazard);
            text_hazard.setText(R.string.hazard_cutting_drilling);
            text_control = findViewById(R.id.text_control);
            text_control.setText(R.string.control_cutting_drilling);
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
