package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.ChecklistGeneral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.ChecklistManagement.ManagementActivity;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.ChecklistWorkers.WorkersActivity;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;

public class GeneralChecklistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_checklist);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.checklist);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        Button general_chekclist = (Button) findViewById(R.id.generalChecklist);
        Button management_chekclist = (Button) findViewById(R.id.managementChecklist);
        Button workers_chekclist = (Button) findViewById(R.id.workersChecklist);

        general_chekclist.setOnClickListener(click);
        management_chekclist.setOnClickListener(click);
        workers_chekclist.setOnClickListener(click);
    }

    private View.OnClickListener click = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()) {
                case R.id.generalChecklist:
                    // String valorTag = v.getTag().toString();
                    //  Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(GeneralChecklistActivity.this, ChecklistActivity.class);
                    startActivity(intent);
                    break;
                case R.id.managementChecklist:
                    // String valorTag = v.getTag().toString();
                    // Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(GeneralChecklistActivity.this, ManagementActivity.class);
                    startActivity(intent);
                    break;

                case R.id.workersChecklist:
                    intent = new Intent(GeneralChecklistActivity.this, WorkersActivity.class);
                    startActivity(intent);
                    break;


            }
        }
    };
}
