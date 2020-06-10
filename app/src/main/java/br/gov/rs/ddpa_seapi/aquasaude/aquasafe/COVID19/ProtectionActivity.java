package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.COVID19;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Utils.PermissoesHandler;

public class ProtectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protection);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.protection_covid19);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        PermissoesHandler permissoes = new PermissoesHandler(ProtectionActivity.this);
        permissoes.askPermissionFile();

        ImageButton hierarchy_button = (ImageButton) findViewById(R.id.hierarchy_control_button);
        ImageButton workplace_button = (ImageButton) findViewById(R.id.workplace_protection_button);
        ImageButton yourself_button = (ImageButton) findViewById(R.id.yourself_protection_button);

        hierarchy_button.setOnClickListener(click);
        workplace_button.setOnClickListener(click);
        yourself_button.setOnClickListener(click);
    }

    private View.OnClickListener click = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.hierarchy_control_button:
                    Intent intent = new Intent(ProtectionActivity.this, ProtectHierarchyActivity.class);
                    startActivity(intent);
                    break;
                case R.id.workplace_protection_button:
                    intent = new Intent(ProtectionActivity.this, ProtectWorkplaceActivity.class);
                    startActivity(intent);
                    break;
                case R.id.yourself_protection_button:
                    intent = new Intent(ProtectionActivity.this, ProtectYourselfActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
