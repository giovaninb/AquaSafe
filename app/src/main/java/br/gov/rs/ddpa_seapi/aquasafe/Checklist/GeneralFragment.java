package br.gov.rs.ddpa_seapi.aquasafe.Checklist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.gov.rs.ddpa_seapi.aquasafe.R;


public class GeneralFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_general, container, false);

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button generalChecklist = (Button) view.findViewById(R.id.generalChecklist);
        Button managementChecklist = (Button) view.findViewById(R.id.managementChecklist);
        Button workersChecklist = (Button) view.findViewById(R.id.workerstChecklist);

        generalChecklist.setOnClickListener(click);
        managementChecklist.setOnClickListener(click);
        workersChecklist.setOnClickListener(click);

        return view;
    }

    private View.OnClickListener click = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.generalChecklist:
                   android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.container_fragment, new IntroductionFragment(), "NewFragmentTag");
                    ft.commit();
                    ft.addToBackStack(null);
                    break;

            }
        }
    };
}
