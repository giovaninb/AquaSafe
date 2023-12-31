package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Quiz;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;


/**
 * Created by eduardo-pooch on 07/10/2016.
 */
public class ListaPerguntas {

    private List<Pergunta> listQuestionsAquasafe;
    Context context;

    public ListaPerguntas(Context context) {
        listQuestionsAquasafe = new ArrayList<>();
        this.context = context;

        ArrayList<Resposta> respostas;
        Pergunta pergunta;

        // Perunta 1
        criaPerguntaTexto(R.string.pergunta_1,
                R.string.pergunta_1_resposta_1,
                R.string.pergunta_1_resposta_certa,
                R.string.pergunta_1_resposta_3,
                R.string.pergunta_1_resposta_4);

        // Perunta 2
        criaPerguntaTexto(R.string.pergunta_2,
                R.string.pergunta_2_resposta_1,
                R.string.pergunta_2_resposta_2,
                R.string.pergunta_2_resposta_certa,
                R.string.pergunta_2_resposta_4);

        // Perunta 3
        criaPerguntaTexto(R.string.pergunta_3,
                R.string.pergunta_3_resposta_certa,
                R.string.pergunta_3_resposta_2,
                R.string.pergunta_3_resposta_3,
                R.string.pergunta_3_resposta_4);

        // Perunta 4
        criaPerguntaTexto(R.string.pergunta_4,
                R.string.pergunta_4_resposta_1,
                R.string.pergunta_4_resposta_2,
                R.string.pergunta_4_resposta_3,
                R.string.pergunta_4_resposta_certa);

        //Pergunta 5
        criaPerguntaTexto(R.string.pergunta_5,
                R.string.pergunta_5_resposta_certa,
                R.string.pergunta_5_resposta_2,
                R.string.pergunta_5_resposta_3,
                R.string.pergunta_5_resposta_4);

        //Pergunta 6
        criaPerguntaTexto(R.string.pergunta_6,
                R.string.pergunta_6_resposta_1,
                R.string.pergunta_6_resposta_2,
                R.string.pergunta_6_resposta_certa,
                R.string.pergunta_6_resposta_4);

        criaPerguntaTexto(R.string.pergunta_7,
                R.string.pergunta_7_resposta_2,
                R.string.pergunta_7_resposta_certa,
                R.string.pergunta_7_resposta_3,
                R.string.pergunta_7_resposta_4);

        criaPerguntaTexto(R.string.pergunta_8,
                R.string.pergunta_8_resposta_certa,
                R.string.pergunta_8_resposta_2,
                R.string.pergunta_8_resposta_3,
                R.string.pergunta_8_resposta_4);

        criaPerguntaTexto(R.string.pergunta_9,
                R.string.pergunta_9_resposta_2,
                R.string.pergunta_9_resposta_3,
                R.string.pergunta_9_resposta_4,
                R.string.pergunta_9_resposta_certa);

        criaPerguntaTexto(R.string.pergunta_10,
                R.string.pergunta_10_resposta_2,
                R.string.pergunta_10_resposta_3,
                R.string.pergunta_10_resposta_certa,
                R.string.pergunta_10_resposta_4);

//        How to add images
//        respostas = new ArrayList<>(4);
//        respostas.add(new Resposta(R.drawable.imagem_peixe, true));
//        respostas.add(new Resposta(R.drawable.imagem_caranguejo, false));
//        respostas.add(new Resposta(R.drawable.imagem_larva, false));
//        respostas.add(new Resposta(R.drawable.imagem_densidade, false));
//        pergunta = new Pergunta(context.getString(R.string.pergunta_1), respostas);
//        listQuestionsAquasafe.add(pergunta);

//        respostas = new ArrayList<>(4);
//        respostas.add(new Resposta(R.drawable.imagem_densidade, false));
//        respostas.add(new Resposta(R.drawable.imagem_temperatura, false));
//        respostas.add(new Resposta(R.drawable.imagem_greenhouse, true));
//        respostas.add(new Resposta(R.drawable.imagem_salinidade, false));
//        pergunta = new Pergunta(context.getString(R.string.pergunta_2), respostas);
//        listQuestionsAquasafe.add(pergunta);

//        respostas = new ArrayList<>(4);
//        respostas.add(new Resposta(R.drawable.imagem_wssv_2, false));
//        respostas.add(new Resposta(R.drawable.imagem_ihhnv, false));
//        respostas.add(new Resposta(R.drawable.imagem_wssv_3, false));
//        respostas.add(new Resposta(R.drawable.imagem_mnv, true));
//        pergunta = new Pergunta(context.getString(R.string.pergunta_3), respostas);
//        listQuestionsAquasafe.add(pergunta);

//        respostas = new ArrayList<>(4);
//        respostas.add(new Resposta(R.drawable.imagem_greenhouse, true));
//        respostas.add(new Resposta(R.drawable.imagem_probiotico, false));
//        respostas.add(new Resposta(R.drawable.imagem_pediluvio, false));
//        respostas.add(new Resposta(R.drawable.imagem_animais_domesticos, true));
//        pergunta = new Pergunta(context.getString(R.string.pergunta_4), respostas);
//        listQuestionsAquasafe.add(pergunta);

    }

    private void criaPerguntaTexto(int resIdPergunta, int resIdResposta_1, int resIdResposta_2,
                                   int resIdResposta_3, int resIdResposta_4) {

        ArrayList<Resposta> respostas = new ArrayList<>(4);

        respostas.add(new Resposta(context.getString(resIdResposta_1), isCerta(resIdResposta_1)));
        respostas.add(new Resposta(context.getString(resIdResposta_2), isCerta(resIdResposta_2)));
        respostas.add(new Resposta(context.getString(resIdResposta_3), isCerta(resIdResposta_3)));
        respostas.add(new Resposta(context.getString(resIdResposta_4), isCerta(resIdResposta_4)));

        Pergunta pergunta = new Pergunta(context.getString(resIdPergunta), respostas);
        listQuestionsAquasafe.add(pergunta);
    }

    private boolean isCerta(int resId){
        return context.getResources().getResourceEntryName(resId).contains("certa");
    }

    public List<Pergunta> getListaPerguntas() {
        return listQuestionsAquasafe;
    }

}
