package br.gov.rs.ddpa_seapi.aquasafe.Checklist;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.gov.rs.ddpa_seapi.aquasafe.R;


public class CheckActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(R.string.checklist);
        setContentView(R.layout.activity_check);



        int[] resultados = getIntent().getIntArrayExtra("resultado");
        if (resultados == null) {
            android.support.v4.app.Fragment fragment = new ChecklistFragment();
            android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_frame, fragment);
            transaction.commit();

        } else {
            FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
            android.support.v4.app.Fragment resultFragment =ResultFragment.newInstance(resultados);
            fragment.add(R.id.content_frame, resultFragment);
            fragment.commit();

        }
    }

}
