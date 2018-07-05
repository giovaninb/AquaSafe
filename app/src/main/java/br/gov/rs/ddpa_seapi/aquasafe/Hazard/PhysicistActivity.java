package br.gov.rs.ddpa_seapi.aquasafe.Hazard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import br.gov.rs.ddpa_seapi.aquasafe.R;

public class PhysicistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physicist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.physicist_title);
        getSupportActionBar().setLogo(R.drawable.toolbar_physicist);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


    }
    public void click(View view) {
        String valueTag = view.getTag().toString();
     //   Toast.makeText(getBaseContext(), valueTag, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(PhysicistActivity.this, GeneralScreenActivity.class);
        intent.putExtra("tagRiscos", valueTag);
        startActivity(intent);
    }

}
