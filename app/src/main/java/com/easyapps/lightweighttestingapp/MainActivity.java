package com.easyapps.lightweighttestingapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isPermissionGranted(Manifest.permission.SEND_SMS) == false) {

            Log.i("flow", "onCreate: right now no Permission, requesting SEND_SMS permission ");
            requestPermission(new String[]{Manifest.permission.SEND_SMS}, 101);
        } else {

            Log.i("flow", "onCreate:SEND_SMS Permission is already been granted by user ");
            if (isPermissionGranted(Manifest.permission.RECEIVE_SMS) == true)
                Log.i("flow", "RECEIVE_SMS permission is also already been granted: ");

        }

    }//onCreate Close

    //..........................................................................................................
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 101: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Log.i("flow", "onRequestPermissionsResult: Case 101, User granted SEND_SMS");
                    Log.i("flow", "onRequestPermissionsResult: Lets check RECEIVE_SMS Permission");

                    if (isPermissionGranted(Manifest.permission.RECEIVE_SMS) == true) {
                        Log.i("flow", "onRequestPermissionsResult:Yes, RECEIVE_SMS permission was also granted with SEND_SMS");
                    } else {
                        Log.i("flow", "onRequestPermissionsResult: RECEIVE_SMS not granted with SEND_SMS permission");
                        Log.i("flow", "onRequestPermissionsResult: now requesting RECEIVE_SMS permission");
                        requestPermission(new String[]{Manifest.permission.RECEIVE_SMS}, 102);
                    }

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            case 102: {
                Log.i("flow", "onRequestPermissionsResult: Case 102 ,Now RECEIVE_SMS permission granted without asking user ");
            }
            //add more cases if you are making more than one permission request
        }
    }

    private boolean isPermissionGranted(String value) {
        if (ActivityCompat.checkSelfPermission(this, value) ==
                PackageManager.PERMISSION_GRANTED)
            return true;
        else
            return false;
    }

    private void requestPermission(String[] value, int requestCode) {
        ActivityCompat.requestPermissions(this, value, requestCode);
    }


}
