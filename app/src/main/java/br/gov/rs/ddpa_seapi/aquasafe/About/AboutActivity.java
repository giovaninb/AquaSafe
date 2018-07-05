package br.gov.rs.ddpa_seapi.aquasafe.About;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import br.gov.rs.ddpa_seapi.aquasafe.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.about);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
