package com.example.flavielli_marques.aquasafe.Checklist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.flavielli_marques.aquasafe.R;

import java.util.ArrayList;


public class ResultFragment extends Fragment {

    private View view;
    private int[] itensDesmarcados;
    private static final String ARG_ITENS_DESMARCADOS = "desmarcados";
    public static final int NOTA_MAXIMA = 15;
    public static final int VALOR_DEFAULT = -1;

    /*Constrtuor Vazio*/
    public ResultFragment() {
    }

    /*Nova instancia que pega o array de itens desmarcados */
    public static ResultFragment newInstance(ArrayList<Integer> itensDesmarcados) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putIntArray(ARG_ITENS_DESMARCADOS, transformaListaEmArray(itensDesmarcados));
        fragment.setArguments(args);
        return fragment;

    }

    /*rever resultado
    public static Fragment newInstance(int[] itensDesmarcados) {
        ResultFragment fragment = new ResultFragment();

        Bundle args = new Bundle();
        args.putIntArray(ARG_ITENS_DESMARCADOS, itensDesmarcados);
        fragment.setArguments(args);
        return fragment;
    }
*/
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

        return view;
    }

  /*  tResultado na tela, mostra a orcentagem de local adequado e chama showTips */
    private void textResult(int score) {
        TextView result = (TextView) view.findViewById(R.id.text_result);
        if (score == NOTA_MAXIMA) {
            result.setText(getString(R.string.result_max));
        } else {
            String strresult = getString(R.string.work) + ((score * 100)/NOTA_MAXIMA) +
                    getString(R.string.porcent);
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

    /*vetor que pega o ID das respostas dos itens que nao foram marcados */
    private int[] getTipsId() {
        return new int[]{R.string.answer_1, R.string.answer_2, R.string.answer_3, R.string.answer_4,
                R.string.answer_5, R.string.answer_6, R.string.answer_7, R.string.answer_8, R.string.answer_9,
                R.string.answer_10, R.string.answer_11, R.string.answer_12, R.string.answer_13, R.string.answer_14,
                R.string.answer_15};
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


/*



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_resultado_checklist, container, false);
        int nota = getNota(); //Valor vai de 0..10

        mudaTextoDoResultado(nota);
        salvarHighScore(nota);
        salvaUltimoResultado();

        Button btOk = (Button) view.findViewById(R.id.bt_ok);
        btOk.setOnClickListener(v -> getActivity().finish());
        return view;
    }

    private void salvaUltimoResultado() {
        //Salva o último resultado como um toString de array
        SharedPreferences banco = getSharedPreferences();
        SharedPreferences.Editor editor = banco.edit();
        editor.putString(getString(R.string.string_itens), Arrays.toString(itensDesmarcados));
        //apply - commit assíncrono - do high score e último resultado - pro usuário poder rever dps
        editor.apply();
    }


    /**
     * Salva o high score na tabela de preferences do android, que é um banco de dados simples
     *
     * @param notaAtual numa escala de 0 a 10
     */
/*    private void salvarHighScore(int notaAtual) {
        SharedPreferences banco = getSharedPreferences();
        int notaGravada = banco.getInt(getString(R.string.nota_checklist), VALOR_DEFAULT);

        if (notaAtual > notaGravada) {
            gravaNotaAtual(banco, notaAtual);
        }
    }

    private void gravaNotaAtual(SharedPreferences banco, int notaAtual) {
        SharedPreferences.Editor editor = banco.edit();
        editor.putInt(getString(R.string.nota_checklist), notaAtual);
        editor.apply();
    }

    private SharedPreferences getSharedPreferences() {
        return getActivity()
                .getSharedPreferences(getString(R.string.nome_shared_pref), Context.MODE_PRIVATE);
    }

    /**
     * Recuperei a informação dos ids em um array para poder recuperar num laço 'for'
     *
     * @return ID das frases de dicas que devem ser mostradas de acordo com o que o usuário deixou
     * de marcar na ChecklistFragment
     */
/*    private int[] getDicasId() {
        return new int[]{R.string.resposta_1, R.string.resposta_2, R.string.resposta_3,
                R.string.resposta_4, R.string.resposta_5, R.string.resposta_6, R.string.resposta_7,
                R.string.resposta_8, R.string.resposta_9, R.string.resposta_10};
    }

/**
 * Os dados são transformados em int[] para passar para a classe de resultados
 *
 * @param listaItensDesmarcados com Integers de 0..9
 * @return int array
 */
