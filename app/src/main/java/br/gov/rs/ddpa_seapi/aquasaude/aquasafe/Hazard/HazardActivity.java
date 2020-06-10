package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Hazard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;


public class HazardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hazard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.types_of_hazard);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        ImageButton physicist_button = (ImageButton) findViewById(R.id.physic);
        ImageButton chemical_button = (ImageButton) findViewById(R.id.chemical);
        ImageButton biological_button = (ImageButton) findViewById(R.id.biologic);
        ImageButton ergonomic_button = (ImageButton) findViewById(R.id.ergonomic);
        ImageButton accident_button = (ImageButton) findViewById(R.id.injurious_incidents);

        physicist_button.setOnClickListener(click);
        chemical_button.setOnClickListener(click);
        biological_button.setOnClickListener(click);
        ergonomic_button.setOnClickListener(click);
        accident_button.setOnClickListener(click);

    }
    private View.OnClickListener click = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.physic:
                    String valorTag = v.getTag().toString();
                   // Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(HazardActivity.this, PhysicistActivity.class);
                    startActivity(intent);
                    break;
                case R.id.chemical:
                    valorTag = v.getTag().toString();
                   // Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(HazardActivity.this, ChemicalActivity.class);
                    startActivity(intent);
                    break;
                case R.id.biologic:
                    valorTag = v.getTag().toString();
                   // Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(HazardActivity.this, BiologicalActivity.class);
                    startActivity(intent);
                    break;
                case R.id.ergonomic:
                    valorTag = v.getTag().toString();
                  //  Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(HazardActivity.this, ErgonomicActivity.class);
                    startActivity(intent);
                    break;
                case R.id.injurious_incidents:
                    valorTag = v.getTag().toString();
                  //  Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(HazardActivity.this, AccidentActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
