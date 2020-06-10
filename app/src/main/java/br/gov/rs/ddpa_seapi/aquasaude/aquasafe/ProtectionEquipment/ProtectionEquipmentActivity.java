package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.ProtectionEquipment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.FiveWhys.FiveWhysActivity;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;


public class ProtectionEquipmentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protection_equipment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.equipment);

        ImageButton help_ppe = findViewById(R.id.help_ppe);
        help_ppe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(ProtectionEquipmentActivity.this).create();
                alertDialog.setTitle(R.string.equipment);
                alertDialog.setMessage(getResources().getString(R.string.help_ppe));
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });

    }

    public void click(View view) {
        String valueTag = view.getTag().toString();
      //  Toast.makeText(getBaseContext(), valueTag, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ProtectionEquipmentActivity.this, GeneralEquipmentActivity.class);
        intent.putExtra("tagEquipamentos", valueTag);
        startActivity(intent);
    }
}