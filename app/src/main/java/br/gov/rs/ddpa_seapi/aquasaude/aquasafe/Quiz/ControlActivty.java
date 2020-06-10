package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Quiz;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;

public class ControlActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_frag);

        android.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame_quiz, new QuizFragment())
                .commit();

    }
}
