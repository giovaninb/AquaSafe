package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.COVID19;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;

public class TransmissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transmission);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.transmission);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
