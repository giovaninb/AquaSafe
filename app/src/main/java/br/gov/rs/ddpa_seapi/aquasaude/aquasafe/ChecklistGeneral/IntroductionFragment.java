package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.ChecklistGeneral;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;


public class IntroductionFragment extends Fragment{

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_introduction, container, false);

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button button = (Button) view.findViewById(R.id.buttonChecklist);
        button.setVisibility(View.VISIBLE);
        button.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), CheckActivity.class));


        });
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getActivity()
                .getSharedPreferences(getString(R.string.name_shared_pref), Context.MODE_PRIVATE);
        int defaultValue = -1;
        int score = sharedPref.getInt(getString(R.string.score_checklist), defaultValue);
        if (score != defaultValue) {
            TextView textView = (TextView) view.findViewById(R.id.text_highscore);
            String texto = getResources().getString(R.string.score)+ score + "/20";
            textView.setText(texto);
        }

        String strLastResult = sharedPref.getString(getString(R.string.string_topics), null);
        try {
            if (strLastResult != null) {
                int[] itensUltimoResultado = toIntArray(strLastResult);

                Button btRever = (Button) view.findViewById(R.id.button_rever);
                btRever.setVisibility(View.VISIBLE);
                Intent intentResultados = new Intent(getActivity(), CheckActivity.class);
                intentResultados.putExtra("resultado",itensUltimoResultado);
                btRever.setOnClickListener(v -> startActivity(intentResultados));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }


    public static int[] toIntArray(String input) {
        String beforeSplit = input.replaceAll("\\[|\\]|\\s", "");
        String[] split = beforeSplit.split("\\,");
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }

}
