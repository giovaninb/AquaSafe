package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.COVID19;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;

public class OtherProtectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_protection);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.other_protection_covid19);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
