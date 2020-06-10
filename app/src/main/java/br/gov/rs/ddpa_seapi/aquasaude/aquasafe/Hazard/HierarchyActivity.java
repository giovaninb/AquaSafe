package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Hazard;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;

public class HierarchyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hierarchy);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView imageView = findViewById(R.id.hierarchy_image);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(HierarchyActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
                imageView.setImageResource(R.drawable.hierarquia);
                mBuilder.setView(mView);
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });

    }
}
