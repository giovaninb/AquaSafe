package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Tools_OSH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;

public class OpportunitiesActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunities);

        // get the listview
        expListView = findViewById(R.id.expandable_opportunities);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding header data
        listDataHeader.add(getResources().getString(R.string.union_representation));
        listDataHeader.add(getResources().getString(R.string.job_of_workers));
        listDataHeader.add(getResources().getString(R.string.government_obligations));
        listDataHeader.add(getResources().getString(R.string.employers_obligations));
        listDataHeader.add(getResources().getString(R.string.workers));

        // Adding child data
        List<String> union_representation = new ArrayList<String>();
        union_representation.add(getResources().getString(R.string.text_union_representation));

        List<String> job_of_workers = new ArrayList<String>();
        job_of_workers.add(getResources().getString(R.string.text_job_of_workers));

        List<String> government_obligations = new ArrayList<String>();
        government_obligations.add(getResources().getString(R.string.text_government_obligations));

        List<String> employers_obligations = new ArrayList<String>();
        employers_obligations.add(getResources().getString(R.string.text_employers_obligations));

        List<String> workers = new ArrayList<String>();
        workers.add(getResources().getString(R.string.text_workers));

        listDataChild.put(listDataHeader.get(0), union_representation); // Header, Child data
        listDataChild.put(listDataHeader.get(1), job_of_workers);
        listDataChild.put(listDataHeader.get(2), government_obligations);
        listDataChild.put(listDataHeader.get(3), employers_obligations);
        listDataChild.put(listDataHeader.get(4), workers);

    }
}
