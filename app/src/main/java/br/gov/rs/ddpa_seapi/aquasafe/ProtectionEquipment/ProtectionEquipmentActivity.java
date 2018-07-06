package br.gov.rs.ddpa_seapi.aquasafe.ProtectionEquipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.gov.rs.ddpa_seapi.aquasafe.Hazard.BiologicalActivity;
import br.gov.rs.ddpa_seapi.aquasafe.Hazard.GeneralScreenActivity;
import br.gov.rs.ddpa_seapi.aquasafe.R;


public class ProtectionEquipmentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protection_equipment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.equipment);

    }
    public void click(View view) {
        String valueTag = view.getTag().toString();
        //   Toast.makeText(getBaseContext(), valueTag, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ProtectionEquipmentActivity.this, GeneralEquipamentActivity.class);
        intent.putExtra("tagRiscos", valueTag);
        startActivity(intent);
    }
}