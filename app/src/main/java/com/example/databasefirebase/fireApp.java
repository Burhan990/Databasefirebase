package com.example.databasefirebase;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Burhan Infinity on 11/30/2017.
 */

public class fireApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
