package br.gov.rs.ddpa_seapi.aquasaude.aquasafe.Utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class PermissoesHandler {

    public static final int CODE_FILE = 1;
    private Activity activity;

    public PermissoesHandler(Activity activity) {
        this.activity = activity;
    }

    public boolean verifyFilePermission() {
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    public void askPermissionFile() {
        ActivityCompat.requestPermissions(activity,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                CODE_FILE);
    }

}
