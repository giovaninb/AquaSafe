package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.COVID19;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;

public class CareWithMaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_with_mask);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.care_with_mask);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
