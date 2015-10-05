package com.theoreticsinc.schoolapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.theoreticsinc.schoolapp.activities.DrawerActivity;
import com.theoreticsinc.schoolapp.activities.DashboardActivity;

public class StarterActivity extends Activity{

    private static final int REQUEST_CODE = 0;
    private static String TAG = "com.theoreticsinc.schoolapp.StarterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        SharedPreferences preferences = getSharedPreferences("SchoolApp", Context.MODE_PRIVATE);
        boolean init = preferences.getBoolean("initialized", false);

        if (init == false) {
            // Enable Local Datastore.
            Parse.enableLocalDatastore(this);
        }

        try {
            // Add your initialization code here
            Parse.initialize(this, "@string/parse_app_id", "@string/parse_client_key");
        }
        catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
        }

        SharedPreferences.Editor edit = preferences.edit();
        edit.putBoolean("initialized", true);
        edit.apply();


        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);

        ParseInstallation.getCurrentInstallation().saveInBackground();

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "SchoolApp");
        testObject.saveInBackground();
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;


        if (currentapiVersion < 14) {
            // Do something for 14 and above versions
            Intent i = new Intent(StarterActivity.this, DashboardActivity.class);
            startActivity(i);
        }
        else if (currentapiVersion >= 14) {
            // Do something for 14 and above versions
            Intent i = new Intent(StarterActivity.this, DrawerActivity.class);
            startActivity(i);
        }
        this.finish();
    }

    @Override
    public void onResume() {
        super.onResume();
        /*
        new AlertDialog.Builder(this)
                .setTitle("Resume Main?")
                .setMessage("Press No to Reset")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        //DashboardActivity.super.onBackPressed();
                        finish();
                    }
                }).create().show();
                */
    }

}
