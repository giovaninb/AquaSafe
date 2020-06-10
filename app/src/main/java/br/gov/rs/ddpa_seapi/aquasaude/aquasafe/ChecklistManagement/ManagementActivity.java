package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.ChecklistManagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;

public class ManagementActivity extends AppCompatActivity {

    TableLayout mainGrid;
    ImageButton btnDiving;
    ImageButton btnProtection;
    ImageButton btnMachines;
    ImageButton btnEletrical;
    ImageButton btnBoating;
    ImageButton btnChemicals;
    ImageButton btnHealth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_checklist);

        btnDiving = findViewById(R.id.diving_item);
        btnProtection = findViewById(R.id.protection_item);
        btnMachines = findViewById(R.id.machines_item);
        btnEletrical = findViewById(R.id.eletrical_item);
        btnBoating = findViewById(R.id.boating_item);
        btnChemicals = findViewById(R.id.chemicals_item);
        btnHealth = findViewById(R.id.womens_item);

        //Set Event
        setChecklistEvent(btnDiving);
        setChecklistEvent(btnProtection);
        setChecklistEvent(btnMachines);
        setChecklistEvent(btnEletrical);
        setChecklistEvent(btnBoating);
        setChecklistEvent(btnChemicals);
        setChecklistEvent(btnHealth);

    }

    private void setChecklistEvent(ImageButton button) {
        String tag = button.getTag().toString();
        //Toast.makeText(ManagementActivity.this,"tag: "+tag,Toast.LENGTH_SHORT).show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManagementActivity.this,ActivityOne.class);
                intent.putExtra("tag",tag);
                startActivity(intent);
            }
        });
    }

}
