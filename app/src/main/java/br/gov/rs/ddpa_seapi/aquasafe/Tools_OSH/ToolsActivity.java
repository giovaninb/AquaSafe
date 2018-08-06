package br.gov.rs.ddpa_seapi.aquasafe.Tools_OSH;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.gov.rs.ddpa_seapi.aquasafe.R;

public class ToolsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
