package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Tools_OSH;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;

public class ToolsOSHActivity extends AppCompatActivity {

    ImageButton workplace;
    ImageButton opportunities;
    String valorTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_osh);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        workplace = findViewById(R.id.workplace);
        opportunities = findViewById(R.id.opportunities);

        workplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ToolsOSHActivity.this, WorkplaceActivity.class);
                startActivity(intent);
//                valorTag = getResources().getString(R.string.soon);
//                Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
            }
        });

        opportunities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // valorTag = getResources().getString(R.string.soon);
                // Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ToolsOSHActivity.this, OpportunitiesActivity.class);
                startActivity(intent);
            }
        });
    }
}
