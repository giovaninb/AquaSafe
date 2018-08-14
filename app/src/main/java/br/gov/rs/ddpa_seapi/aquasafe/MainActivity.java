package br.gov.rs.ddpa_seapi.aquasafe;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import br.gov.rs.ddpa_seapi.aquasafe.About.AboutActivity;
import br.gov.rs.ddpa_seapi.aquasafe.Checklist.ChecklistActivity;
import br.gov.rs.ddpa_seapi.aquasafe.Checklist.GeneralChecklistActivity;
import br.gov.rs.ddpa_seapi.aquasafe.Hazard.MainSpecificActivity;
import br.gov.rs.ddpa_seapi.aquasafe.ProtectionEquipment.ProtectionEquipmentActivity;
import br.gov.rs.ddpa_seapi.aquasafe.Tools_OSH.ToolsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton hazard_button = (ImageButton) findViewById(R.id.hazard);
        ImageButton checklist_button = (ImageButton) findViewById(R.id.checklist);
        ImageButton equipment_button = (ImageButton) findViewById(R.id.equipment);
        ImageButton tools_button = (ImageButton) findViewById(R.id.tools);
        ImageButton about_button = (ImageButton) findViewById(R.id.about);
        ImageButton contact_button = (ImageButton) findViewById(R.id.contact);

        hazard_button.setOnClickListener(click);
        checklist_button.setOnClickListener(click);
        equipment_button.setOnClickListener(click);
        tools_button.setOnClickListener(click);
        about_button.setOnClickListener(click);
        contact_button.setOnClickListener(click);
    }
    private View.OnClickListener click = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.hazard:
                    String valorTag = v.getTag().toString();
                  //  Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainSpecificActivity.class);
                    startActivity(intent);
                    break;

                case R.id.checklist:
                    valorTag = v.getTag().toString();
                 //   Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, GeneralChecklistActivity.class);
                    startActivity(intent);
                    break;

                case R.id.equipment:
                    valorTag = v.getTag().toString();
                //    Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, ProtectionEquipmentActivity.class);
                    startActivity(intent);
                    break;

                case R.id.tools:
                    valorTag = v.getTag().toString();
                  //  Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, ToolsActivity.class);
                    startActivity(intent);
                    break;

                case R.id.about:
                    valorTag = v.getTag().toString();
                    //  Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, AboutActivity.class);
                    startActivity(intent);
                    break;

                case R.id.contact:
                    valorTag = v.getTag().toString();
                   // Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    String[] emails = {"aquassaude@gmail.com"};
                    String assunto = getString(R.string.title_email);
                    Intent intentEmail = new Intent(Intent.ACTION_SENDTO);
                    intentEmail.setData(Uri.parse("mailto:"));
                    intentEmail.putExtra(Intent.EXTRA_EMAIL, emails);
                    intentEmail.putExtra(Intent.EXTRA_SUBJECT, assunto);
                    if (intentEmail.resolveActivity(getPackageManager()) != null) {
                        startActivity(intentEmail);
                    }
                    break;

            }
        }
    };
}