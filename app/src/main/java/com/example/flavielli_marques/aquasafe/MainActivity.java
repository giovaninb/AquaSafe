package com.example.flavielli_marques.aquasafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton hazard_button = (ImageButton) findViewById(R.id.hazard);
        hazard_button.setOnClickListener(click);
    }
    private View.OnClickListener click = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.hazard:
                    String valorTag = v.getTag().toString();
                    Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, HazardActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

}