package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.COVID19;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;

public class WhichMaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_which_mask);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.which_mask);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
