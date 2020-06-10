package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.COVID19;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;

public class MaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mask);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.mask_covid19);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        ImageButton which_mask_button = (ImageButton) findViewById(R.id.which_mask);
        ImageButton non_sururgical_mask_button = (ImageButton) findViewById(R.id.non_sururgical_mask);
        ImageButton how_to_use_it_button = (ImageButton) findViewById(R.id.how_to_use_it);
        ImageButton care_mask_button = (ImageButton) findViewById(R.id.care_mask);
        ImageButton fabric_mask_button = (ImageButton) findViewById(R.id.fabric_mask);
        ImageButton mask_disposal_button = (ImageButton) findViewById(R.id.mask_disposal);

        which_mask_button.setOnClickListener(click);
        non_sururgical_mask_button.setOnClickListener(click);
        how_to_use_it_button.setOnClickListener(click);
        care_mask_button.setOnClickListener(click);
        fabric_mask_button.setOnClickListener(click);
        mask_disposal_button.setOnClickListener(click);
    }

    private View.OnClickListener click = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.which_mask:
                    Intent intent = new Intent(MaskActivity.this, WhichMaskActivity.class);
                    startActivity(intent);
                    break;
                case R.id.non_sururgical_mask:
                    intent = new Intent(MaskActivity.this, NonSirurgicalMaskActivity.class);
                    startActivity(intent);
                    break;
                case R.id.how_to_use_it:
                    intent = new Intent(MaskActivity.this, HowToUseMaskActivity.class);
                    startActivity(intent);
                    break;
                case R.id.care_mask:
                    intent = new Intent(MaskActivity.this, CareWithMaskActivity.class);
                    startActivity(intent);
                    break;
                case R.id.fabric_mask:
                    intent = new Intent(MaskActivity.this, CareFabricMaskActivity.class);
                    startActivity(intent);
                    break;
                case R.id.mask_disposal:
                    intent = new Intent(MaskActivity.this, DisposalMaskActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
