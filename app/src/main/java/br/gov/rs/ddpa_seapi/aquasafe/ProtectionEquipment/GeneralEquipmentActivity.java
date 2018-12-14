package br.gov.rs.ddpa_seapi.aquasafe.ProtectionEquipment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import br.gov.rs.ddpa_seapi.aquasafe.R;

public class GeneralEquipmentActivity extends AppCompatActivity {
    TextView text_equipment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_equipment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String tag = getIntent().getStringExtra("tagEquipamentos");

        if (tag.equals("floating_equipment")) {
            View viewById = findViewById(R.id.content_general_equipment);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.floating);
            text_equipment = findViewById(R.id.text_equipment);
            text_equipment.setText(R.string.text_floating_equipment);

        } else if (tag.equals("protective_clothing")) {
            View viewById = findViewById(R.id.content_general_equipment);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.protecting);
            text_equipment = findViewById(R.id.text_equipment);
            text_equipment.setText(R.string.protective_clothing);

        }
    }

}
