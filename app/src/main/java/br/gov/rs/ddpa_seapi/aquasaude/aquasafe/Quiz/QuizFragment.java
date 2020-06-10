package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Quiz;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;


public class QuizFragment extends Fragment {

    private ImageView object;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.content_choose_game, container, false);
        View buttonStartQuiz = view.findViewById(R.id.btnStartQuiz);
        object = view.findViewById(R.id.animation_quiz);

        View animImg = view.findViewById(R.id.animation_quiz);
         animImg.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 //Toast.makeText(getActivity().getApplicationContext(),"teste", Toast.LENGTH_SHORT).show();
                 Animation anim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.anim_scale_down);
                 object.startAnimation(anim);
             }
         });

        buttonStartQuiz.setOnClickListener(v -> {
            Intent intentStartQuiz = new Intent(getActivity(), QuizActivity.class);
            startActivity(intentStartQuiz);
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        configuraHighScore();
    }

    public int pegaUltima(){
        int notaFinal = 0;
        SharedPreferences banquinho = getSharedPreferences();
        banquinho.getInt(getString(R.string.nota_quiz), notaFinal);
        return notaFinal;
    }

    private SharedPreferences getSharedPreferences() {
        return getActivity()
                .getSharedPreferences(getString(R.string.name_shared_pref), Context.MODE_PRIVATE);
    }

    private void configuraHighScore() {
        SharedPreferences sharedPref = getActivity()
                .getSharedPreferences(getString(R.string.name_shared_pref), Context.MODE_PRIVATE);
        int defaultValue = -1;
        int nota = sharedPref.getInt(getString(R.string.nota_quiz), defaultValue);
        if (nota != defaultValue) {
            TextView textView = (TextView) view.findViewById(R.id.text_highscore_quiz);
            textView.setVisibility(View.VISIBLE);
            String texto = getResources().getString(R.string.highscore) + nota;
            textView.setText(texto);
        }
    }


}