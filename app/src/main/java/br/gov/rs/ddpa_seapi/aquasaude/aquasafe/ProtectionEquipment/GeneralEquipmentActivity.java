package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.ProtectionEquipment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;


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

        }else if (tag.equals("eye_protection")) {
            View viewById = findViewById(R.id.content_general_equipment);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.eye_protection);
            text_equipment = findViewById(R.id.text_equipment);
            text_equipment.setText(R.string.eye_protection_text);

        }else if (tag.equals("hearing_protection")) {
            View viewById = findViewById(R.id.content_general_equipment);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.hearing_protection);
            text_equipment = findViewById(R.id.text_equipment);
            text_equipment.setText(R.string.hearing_protection_text);

        }else if (tag.equals("sign_protection")) {
            View viewById = findViewById(R.id.content_general_equipment);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.sign_protection);
            text_equipment = findViewById(R.id.text_equipment);
            text_equipment.setText(R.string.sign_protection_text);

        } else if (tag.equals("fire_protection")) {
            View viewById = findViewById(R.id.content_general_equipment);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.fire_protection);
            text_equipment = findViewById(R.id.text_equipment);
            text_equipment.setText(R.string.fire_protection_text);

        }else if (tag.equals("first_aid")) {
            View viewById = findViewById(R.id.content_general_equipment);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.first_aid);
            text_equipment = findViewById(R.id.text_equipment);
            text_equipment.setText(R.string.first_aid_text);

        }else if (tag.equals("electrical_shock_protection")) {
            View viewById = findViewById(R.id.content_general_equipment);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.electrical_shock_protection);
            text_equipment = findViewById(R.id.text_equipment);
            text_equipment.setText(R.string.electrical_shock_protection_text);

        }else if (tag.equals("chemical_protection")) {
            View viewById = findViewById(R.id.content_general_equipment);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.chemical_protection);
            text_equipment = findViewById(R.id.text_equipment);
            text_equipment.setText(R.string.chemical_protection_text);

        }else if (tag.equals("diving_protection")) {
            View viewById = findViewById(R.id.content_general_equipment);
            viewById.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle(R.string.diving_protection);
            text_equipment = findViewById(R.id.text_equipment);
            text_equipment.setText(R.string.diving_protection_text);

        }
    }

}
