package com.example.flavielli_marques.aquasafe.Checklist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.flavielli_marques.aquasafe.R;

import java.util.ArrayList;

public class ChecklistFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_checklist, container, false);

        Button button_confirm = (Button) view.findViewById(R.id.bt_confirma_checklist);
        button_confirm.setOnClickListener(v -> openResult(view));

        return view;
    }

    private void openResult(View view) {
        ArrayList<Integer> listaItemDesmarcados = getItensDesmarcados(view);
        Fragment fragment = ResultFragment.newInstance(listaItemDesmarcados);
        getFragmentManager().beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
    }



    private ArrayList<Integer> getItensDesmarcados(View view) {
        ArrayList<Integer> listaItensDesmarcados = new ArrayList<>();

        int[] checkBoxResId = getIdsDasCheckBoxes();
        int quantidadeDeItens = checkBoxResId.length;
        for (int i = 0; i < quantidadeDeItens; i++) {
            int resId = checkBoxResId[i];
            CheckBox checkBox = (CheckBox) view.findViewById(resId);
            if (!checkBox.isChecked()) {
                listaItensDesmarcados.add(i);
            }
        }
        return listaItensDesmarcados;
    }



    private int[] getIdsDasCheckBoxes() {
        return new int[]{R.id.checkbox_1, R.id.checkbox_2, R.id.checkbox_3,
                R.id.checkbox_4, R.id.checkbox_5, R.id.checkbox_6, R.id.checkbox_7, R.id.checkbox_8,
                R.id.checkbox_9, R.id.checkbox_10};
    }
}
