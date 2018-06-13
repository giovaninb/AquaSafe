package com.example.flavielli_marques.aquasafe.Immunization;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.flavielli_marques.aquasafe.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ImmunizationActivity extends AppCompatActivity {

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immunization);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.immunization);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.link);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AssetManager assetManager = getAssets();

                InputStream in = null;
                OutputStream out = null;
                File file = new File(getFilesDir(), "calendario_vacinacao_ocupacional.pdf");
                try
                {
                    in = assetManager.open("calendario_vacinacao_ocupacional.pdf");
                    out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

                    copyFile(in, out);
                    in.close();
                    in = null;
                    out.flush();
                    out.close();
                    out = null;
                } catch (Exception e)
                {
                    Log.e("tag", e.getMessage());
                }

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(
                        Uri.parse("file://" + getFilesDir() + "/calendario_vacinacao_ocupacional.pdf"),
                        "application/pdf");

                startActivity(intent);
            }

            private void copyFile(InputStream in, OutputStream out) throws IOException
            {
                byte[] buffer = new byte[1024];
                int read;
                while ((read = in.read(buffer)) != -1)
                {
                    out.write(buffer, 0, read);
                }
            }

        });

    }
}
