package br.gov.rs.ddpa_seapi.aquasafe.Hazard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.gov.rs.ddpa_seapi.aquasafe.R;

public class HierarchyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hierarchy);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.hierarchy);
    }
}
