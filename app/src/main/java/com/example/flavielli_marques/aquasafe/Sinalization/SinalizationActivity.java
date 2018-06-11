package com.example.flavielli_marques.aquasafe.Sinalization;


import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.flavielli_marques.aquasafe.R;


public class SinalizationActivity extends AppCompatActivity {
    Button button;
    DownloadManager downloadManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinalization);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.signalization);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        button = (Button) findViewById(R.id.link);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
               Uri uri = Uri.parse("https://sbim.org.br/images/calendarios/calend-sbim-ocupacional.pdf");
               DownloadManager.Request request = new DownloadManager.Request(uri);
               request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
               Long references = downloadManager.enqueue(request);
            }
        });

    }
}
