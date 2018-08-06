package br.gov.rs.ddpa_seapi.aquasafe.Hazard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import br.gov.rs.ddpa_seapi.aquasafe.R;
import br.gov.rs.ddpa_seapi.aquasafe.Tools_OSH.ToolsActivity;


public class MainSpecificActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_specific);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.hazard);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        ImageButton explanation_button = (ImageButton) findViewById(R.id.risk_explanation);
        ImageButton hierarchy_button = (ImageButton) findViewById(R.id.hierarchy_control);
        ImageButton risks_button = (ImageButton) findViewById(R.id.risks);


        explanation_button.setOnClickListener(click);
        hierarchy_button.setOnClickListener(click);
        risks_button.setOnClickListener(click);
    }

    private View.OnClickListener click = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.risk_explanation:
                    String valorTag = v.getTag().toString();
                    Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.hierarchy_control:
                    valorTag = v.getTag().toString();
                    Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.risks:
                    valorTag = v.getTag().toString();
                  //  Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainSpecificActivity.this, HazardActivity.class);
                    startActivity(intent);
                    break;
            }
        }

    };
}
