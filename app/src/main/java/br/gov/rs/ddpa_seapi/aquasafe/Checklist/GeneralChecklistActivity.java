package br.gov.rs.ddpa_seapi.aquasafe.Checklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import br.gov.rs.ddpa_seapi.aquasafe.Hazard.MainSpecificActivity;
import br.gov.rs.ddpa_seapi.aquasafe.MainActivity;
import br.gov.rs.ddpa_seapi.aquasafe.R;

public class GeneralChecklistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_checklist);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.checklist);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        Button general_chekclist = (Button) findViewById(R.id.generalChecklist);
        general_chekclist.setOnClickListener(click);
    }

    private View.OnClickListener click = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.generalChecklist:
                    String valorTag = v.getTag().toString();
                    //  Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(GeneralChecklistActivity.this, ChecklistActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
