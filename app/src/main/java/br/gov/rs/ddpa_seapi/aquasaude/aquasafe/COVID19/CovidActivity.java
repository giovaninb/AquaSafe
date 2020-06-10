package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.COVID19;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Tools_OSH.ToolsOSHActivity;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Tools_OSH.WorkplaceActivity;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Utils.PermissoesHandler;

public class CovidActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid19);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.covid19);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        PermissoesHandler permissoes = new PermissoesHandler(CovidActivity.this);
        permissoes.askPermissionFile();

        ImageButton what_is_sars_button = (ImageButton) findViewById(R.id.what_is_sars);
        ImageButton symptoms_button = (ImageButton) findViewById(R.id.symptoms);
        ImageButton transmission_button = (ImageButton) findViewById(R.id.transmission);
        ImageButton protection_button = (ImageButton) findViewById(R.id.protection_covid19);
        ImageButton mask_button = (ImageButton) findViewById(R.id.mask_covid19);
        ImageButton other_protection_button = (ImageButton) findViewById(R.id.other_protection_covid19);

        what_is_sars_button.setOnClickListener(click);
        symptoms_button.setOnClickListener(click);
        transmission_button.setOnClickListener(click);
        protection_button.setOnClickListener(click);
        mask_button.setOnClickListener(click);
        other_protection_button.setOnClickListener(click);
    }

    private View.OnClickListener click = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.what_is_sars:
                    //Intent intent = new Intent(CovidActivity.this, what_is_sars_Activity.class);
                    //startActivity(intent);
                    AlertDialog alertDialog = new AlertDialog.Builder(CovidActivity.this).create();
                    alertDialog.setTitle(R.string.what_is_sars);
                    alertDialog.setMessage(getResources().getString(R.string.what_is_sars_text));
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                    break;

                case R.id.symptoms:
                    Intent intent = new Intent(CovidActivity.this, SymptomsActivity.class);
                    startActivity(intent);
                    break;

                case R.id.transmission:
                    intent = new Intent(CovidActivity.this, TransmissionActivity.class);
                    startActivity(intent);
                    break;

                case R.id.protection_covid19:
                    intent = new Intent(CovidActivity.this, ProtectionActivity.class);
                    startActivity(intent);
                    break;

                case R.id.mask_covid19:
                    intent = new Intent(CovidActivity.this, MaskActivity.class);
                    startActivity(intent);
                    break;

                case R.id.other_protection_covid19:
                    intent = new Intent(CovidActivity.this, OtherProtectionActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
