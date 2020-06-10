package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Tools_OSH;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.R;


public class WorkplaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workplace);

        Button btnReferences1 = findViewById(R.id.references_btn_1);
        btnReferences1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.ilo.org/public/english/standards/relm/ilc/ilc89/pdf/c184.pdf"));
                startActivity(i);
            }
        });

        ImageButton imgBtnReferences1 = findViewById(R.id.references_imgBtn_1);
        imgBtnReferences1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.ilo.org/public/english/standards/relm/ilc/ilc89/pdf/c184.pdf"));
                startActivity(i);
            }
        });

        Button btnReferences2 = findViewById(R.id.references_btn_2);
        btnReferences2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.ilo.org/global/publications/books/WCMS_159457/lang--en/index.htm"));
                startActivity(i);
            }
        });

        ImageButton imgBtnReferences2 = findViewById(R.id.references_imgBtn_2);
        imgBtnReferences2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.ilo.org/global/publications/books/WCMS_159457/lang--en/index.htm"));
                startActivity(i);
            }
        });

        Button btnReferences3 = findViewById(R.id.references_btn_3);
        btnReferences3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.ilo.org/wcmsp5/groups/public/---ed_dialogue/---actrav/documents/publication/wcms_111413.pdf"));
                startActivity(i);
            }
        });

        ImageButton imgBtnReferences3 = findViewById(R.id.references_imgBtn_3);
        imgBtnReferences3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.ilo.org/wcmsp5/groups/public/---ed_dialogue/---actrav/documents/publication/wcms_111413.pdf"));
                startActivity(i);
            }
        });
    }
}
