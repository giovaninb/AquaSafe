package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Tools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.FiveWhys.FiveWhysActivity;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.WhatIf.WhatIfActivity;

public class ToolsActivity extends AppCompatActivity {

    ImageButton five_whys;
    ImageButton what_if;
    String valorTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        five_whys = findViewById(R.id.five_whys);
        what_if = findViewById(R.id.what_if);

        five_whys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ToolsActivity.this, FiveWhysActivity.class);
                startActivity(intent);
            }
        });

        what_if.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                valorTag = getResources().getString(R.string.soon);
//                Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ToolsActivity.this, WhatIfActivity.class);
                startActivity(intent);
            }
        });
    }
}
