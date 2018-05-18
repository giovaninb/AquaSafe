package com.example.flavielli_marques.aquasafe.Checklist;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.flavielli_marques.aquasafe.Hazard.HazardActivity;
import com.example.flavielli_marques.aquasafe.MainActivity;
import com.example.flavielli_marques.aquasafe.R;

public class IntroductionFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_introduction, container, false);

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        Button button = (Button) view.findViewById(R.id.buttonChecklist);
        button.setVisibility(View.VISIBLE);
        button.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        String valorTag = view.getTag().toString();
        Toast.makeText(getActivity(), valorTag, Toast.LENGTH_SHORT).show();
        switch(view.getId()){
            case R.id.buttonChecklist:
              /*  FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container_fragment, new ChecklistFragment(), "NewFragmentTag");
                ft.commit();
                ft.addToBackStack(null);*/
                Intent intent = new Intent(getActivity(), CheckActivity.class);
                startActivity(intent);
                break;
        }
    }
}
