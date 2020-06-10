package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.About;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.about);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        Button otherProject = findViewById(R.id.another_project);
        otherProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://aqua-inova.firebaseapp.com/"));
                startActivity(i);
            }
        });
    }
}
