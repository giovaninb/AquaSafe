package br.gov.rs.ddpa_seapi.aquasaude.aquasafe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.About.AboutActivity;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.COVID19.CovidActivity;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.ChecklistGeneral.GeneralChecklistActivity;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Hazard.MainSpecificActivity;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.ProtectionEquipment.ProtectionEquipmentActivity;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Quiz.ControlActivty;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Tools.ToolsActivity;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Tools_OSH.ToolsOSHActivity;
import br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Utils.PermissoesHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PermissoesHandler permissoes = new PermissoesHandler(MainActivity.this);
        permissoes.askPermissionFile();

        ImageButton hazard_button = (ImageButton) findViewById(R.id.hazard);
        ImageButton checklist_button = (ImageButton) findViewById(R.id.checklist);
        ImageButton equipment_button = (ImageButton) findViewById(R.id.equipment);
        ImageButton tools_button = (ImageButton) findViewById(R.id.tools);
        ImageButton osh_tools = (ImageButton) findViewById(R.id.osh_management);
        ImageButton about_button = (ImageButton) findViewById(R.id.about);
        ImageButton youtube_button = (ImageButton) findViewById(R.id.youtube_videos);
        ImageButton quiz_button = (ImageButton) findViewById(R.id.quiz);
        ImageButton covid19_button = (ImageButton) findViewById(R.id.covid19);
        ImageButton whatsapp_button = (ImageButton) findViewById(R.id.whatsapp);
        //Button whatsapp = findViewById(R.id.whats_group);
        Button share = findViewById(R.id.share_app);
        Button contact = findViewById(R.id.contact);


//        whatsapp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                whatsapp_share();
//            }
//        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                share();
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email_contact();
            }
        });

        hazard_button.setOnClickListener(click);
        checklist_button.setOnClickListener(click);
        equipment_button.setOnClickListener(click);
        osh_tools.setOnClickListener(click);
        tools_button.setOnClickListener(click);
        quiz_button.setOnClickListener(click);
        about_button.setOnClickListener(click);
        youtube_button.setOnClickListener(click);
        covid19_button.setOnClickListener(click);
        whatsapp_button.setOnClickListener(click);
    }

    private View.OnClickListener click = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.hazard:
                    String valorTag = v.getTag().toString();
                    // Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainSpecificActivity.class);
                    startActivity(intent);
                    break;

                case R.id.checklist:
                    valorTag = v.getTag().toString();
                    // Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, GeneralChecklistActivity.class);
                    startActivity(intent);
                    break;

                case R.id.equipment:
                    valorTag = v.getTag().toString();
                    // Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, ProtectionEquipmentActivity.class);
                    startActivity(intent);
                    break;
                case R.id.osh_management:
                    // valorTag = getResources().getString(R.string.soon);
                    // Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, ToolsOSHActivity.class);
                    startActivity(intent);
                    break;
                case R.id.tools:
                    valorTag = v.getTag().toString();
                    // Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, ToolsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.quiz:
                    // valorTag = v.getTag().toString();
                    // Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, ControlActivty.class);
                    startActivity(intent);
                    break;

                case R.id.about:
                    valorTag = v.getTag().toString();
                    // Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, AboutActivity.class);
                    startActivity(intent);
                    break;
                case R.id.youtube_videos:
                    valorTag = v.getTag().toString();
                    // Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCVlP7kQKH2lz4fILh9XpeRA/")));
                    break;
                case R.id.covid19:
                    valorTag = v.getTag().toString();
                    // Toast.makeText(getBaseContext(), valorTag, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, CovidActivity.class);
                    startActivity(intent);
                    break;

                case R.id.whatsapp:
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Whatsapp");
                    alertDialog.setMessage(getResources().getString(R.string.whatsapp_text));
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getResources().getString(R.string.whatsapp_join),
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.whatsapp.com/Bphfup3IU8dI1rMf5rV5ez"));
                                    startActivity(browserIntent);
                                }
                            });
                    alertDialog.show();
                    break;

            }
        }
    };

    private void share() {
        String message = getString(R.string.msg_share);
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(share, getResources().getString(R.string.share)));
    }

    private void whatsapp_share() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse("https://chat.whatsapp.com/LA26ZXA9NRe7f95KDs2qev"));
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }
    }

    private void email_contact() {
        String[] emails = {"aquassaude@gmail.com"};
        String assunto = getString(R.string.title_email);
        Intent intentEmail = new Intent(Intent.ACTION_SENDTO);
        intentEmail.setData(Uri.parse("mailto:"));
        intentEmail.putExtra(Intent.EXTRA_EMAIL, emails);
        intentEmail.putExtra(Intent.EXTRA_SUBJECT, assunto);
        if (intentEmail.resolveActivity(getPackageManager()) != null) {
            startActivity(intentEmail);
        }
    }

}