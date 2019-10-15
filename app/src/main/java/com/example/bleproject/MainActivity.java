package com.example.bleproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.BLUETOOTH;
import static android.Manifest.permission.BLUETOOTH_ADMIN;

public class MainActivity extends AppCompatActivity {
    private final String[] permissions = {"android.permission.COARSE_LOCATION", "android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN"};
    private final int PERMISSION_REQUEST_CODE = 200;

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView)findViewById(R.id.txt);

        boolean perm = checkPermissions();
        if(!perm){
            requestPermissions();
        }
    }

    // https://www.journaldev.com/10409/android-runtime-permissions-example
    // check for permission states
    private boolean checkPermissions() {
        int res1 = ContextCompat.checkSelfPermission(this, ACCESS_COARSE_LOCATION);
        int res2 = ContextCompat.checkSelfPermission(this, BLUETOOTH);
        int res3 =  ContextCompat.checkSelfPermission(this, BLUETOOTH_ADMIN);

        return res1 == PackageManager.PERMISSION_GRANTED && res2 == PackageManager.PERMISSION_GRANTED && res3 == PackageManager.PERMISSION_GRANTED;
    }

    // ask for permissions
    public void requestPermissions(){
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_COARSE_LOCATION, BLUETOOTH, BLUETOOTH_ADMIN}, PERMISSION_REQUEST_CODE);
    }
}
