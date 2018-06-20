package com.example.flavielli_marques.aquasafe;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.flavielli_marques.aquasafe.About.AboutActivity;
import com.example.flavielli_marques.aquasafe.Checklist.ChecklistActivity;
import com.example.flavielli_marques.aquasafe.Hazard.HazardActivity;
import com.example.flavielli_marques.aquasafe.SimpleSolution.SimpleSolutionActivity;
import com.example.flavielli_marques.aquasafe.ProtectionEquipment.ProtectionEquipmentActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton hazard_button = (ImageButton) findViewById(R.id.hazard);
        ImageButton checklist_button = (ImageButton) findViewById(R.id.checklist);
        ImageButton equipment_button = (ImageButton) findViewById(R.id.equipment);
        ImageButton simple_solution_button = (ImageButton) findViewById(R.id.simple_solution);
        ImageButton about_button = (ImageButton) findViewById(R.id.about);
        ImageButton contact_button = (ImageButton) findViewById(R.id.contact);

        hazard_button.setOnClickListener(click);
        checklist_button.setOnClickListener(click);
        equipment_button.setOnClickListener(click);
        simple_solution_button.setOnClickListener(click);
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
                    Intent intent = new Intent(MainActivity.this, HazardActivity.class);
                    startActivity(intent);
                    break;

                case R.id.checklist:
                    valorTag = v.getTag().toString();
                 //   Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, ChecklistActivity.class);
                    startActivity(intent);
                    break;

                case R.id.equipment:
                    valorTag = v.getTag().toString();
                //    Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, ProtectionEquipmentActivity.class);
                    startActivity(intent);
                    break;

                case R.id.simple_solution:
                    valorTag = v.getTag().toString();
                //    Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, SimpleSolutionActivity.class);
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