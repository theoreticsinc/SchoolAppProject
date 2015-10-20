/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.theoreticsinc.schoolapp;

import android.app.Application;
import android.provider.Settings;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseInstallation;
import com.parse.ParseUser;


public class StarterApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);

    // Add your initialization code here
   // Parse.initialize(this);
    Parse.initialize(this, "mkXLwHphEdaXHlNMB6VKLxiT6aEgakLneUsXrmly", "3mvmlR6HN5KUfuaCRfJKhaSLXZGj6OO0oUrf1gGL");
    ParseInstallation.getCurrentInstallation().saveInBackground();

    String android_id = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
    ParseInstallation.getCurrentInstallation().put("Unique_Id", android_id);
    ParseInstallation.getCurrentInstallation().saveInBackground();

    ParseUser.enableAutomaticUser();
    ParseACL defaultACL = new ParseACL();
    // Optionally enable public read access.
    // defaultACL.setPublicReadAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);
  }
}
