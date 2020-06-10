package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.ChecklistGeneral;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Arrays;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;


public class ResultFragment extends Fragment {

    private View view;
    private int[] itensDesmarcados;
    private static final String ARG_ITENS_DESMARCADOS = "desmarcados";
    public static final int NOTA_MAXIMA = 20;
    public static final int VALOR_DEFAULT = -1;

    /*Constrtuor Vazio*/
    public ResultFragment() {
    }

    /*Nova instancia que pega o array de itens desmarcados */
    public static Fragment newInstance(ArrayList<Integer> itensDesmarcados) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putIntArray(ARG_ITENS_DESMARCADOS, transformaListaEmArray(itensDesmarcados));
        fragment.setArguments(args);
        return fragment;
    }

    public static Fragment newInstance(int[] itensDesmarcados) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putIntArray(ARG_ITENS_DESMARCADOS, itensDesmarcados);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itensDesmarcados = getArguments().getIntArray(ARG_ITENS_DESMARCADOS);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_result, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();

        int score = getScore();
        textResult(score);
        highScore(score);
        saveLastScore();

        Button button_OK = (Button) view.findViewById(R.id.button_ok);
        button_OK.setOnClickListener(v -> getActivity().finish());
        return view;
    }


    /*  tResultado na tela, mostra a orcentagem de local adequado e chama showTips */
    private void textResult(int score) {
        TextView result = (TextView) view.findViewById(R.id.text_result);
        if (score == NOTA_MAXIMA) {
            result.setText(getString(R.string.result_max));
        } else {
            String strresult = getString(R.string.result_checklist);
            result.setText(strresult);
            showTips();
        }
    }

    /*mostra as dicas para os itens que nao foram marcados no checklist */
    private void showTips() {
        view.findViewById(R.id.card_tips).setVisibility(View.VISIBLE);
        int[] tipsResId = getTipsId();

        StringBuilder builderTips = new StringBuilder();
        for (int indiceDoItem : itensDesmarcados) {
            String dica = getString(tipsResId[indiceDoItem]);
            builderTips.append(dica).append("\n\n");
        }

        String tips = builderTips.toString();
        TextView textViewDicas = (TextView) view.findViewById(R.id.tips);
        textViewDicas.setText(tips);
    }

    private void highScore(int score) {
        SharedPreferences bank = getSharedPreferences();
        int saveScore = bank.getInt(getString(R.string.score_checklist), VALOR_DEFAULT);

        if (score > saveScore) {
            saveScoreNew(bank, score);
        }

    }

    private void saveScoreNew(SharedPreferences bank, int score) {
        SharedPreferences.Editor editor = bank.edit();
        editor.putInt(getString(R.string.score_checklist), score);
        editor.apply();

    }

    private SharedPreferences getSharedPreferences() {
        return getActivity()
                .getSharedPreferences(getString(R.string.name_shared_pref), Context.MODE_PRIVATE);
    }

    private void saveLastScore() {
        //Salva o último resultado como um toString de array
        SharedPreferences bank = getSharedPreferences();
        SharedPreferences.Editor editor = bank.edit();
        editor.putString(getString(R.string.string_topics), Arrays.toString(itensDesmarcados));
        //apply - commit assíncrono - do high score e último resultado - pro usuário poder rever dps
        editor.apply();
    }

    /*vetor que pega o ID das respostas dos itens que nao foram marcados */
    private int[] getTipsId() {
        return new int[]{R.string.answer_1, R.string.answer_2, R.string.answer_3, R.string.answer_4,
                R.string.answer_5, R.string.answer_6, R.string.answer_7, R.string.answer_8, R.string.answer_9,
                R.string.answer_10, R.string.answer_11, R.string.answer_12, R.string.answer_13, R.string.answer_14,
                R.string.answer_15, R.string.answer_16, R.string.answer_17, R.string.answer_18, R.string.answer_19,
                R.string.answer_20};
    }

    private int getScore() {
        return (NOTA_MAXIMA - itensDesmarcados.length);
    }


    private static int[] transformaListaEmArray(ArrayList<Integer> listaItensDesmarcados) {
        int[] arrayItensDesmarcados = new int[listaItensDesmarcados.size()];
        for (int i = 0; i < listaItensDesmarcados.size(); i++)
            arrayItensDesmarcados[i] = listaItensDesmarcados.get(i);
        return arrayItensDesmarcados;
    }
}