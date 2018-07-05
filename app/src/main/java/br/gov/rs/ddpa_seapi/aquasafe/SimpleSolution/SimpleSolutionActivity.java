package br.gov.rs.ddpa_seapi.aquasafe.SimpleSolution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import br.gov.rs.ddpa_seapi.aquasafe.R;


public class SimpleSolutionActivity extends AppCompatActivity {

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_solution);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.simple_solution);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

    }
}
