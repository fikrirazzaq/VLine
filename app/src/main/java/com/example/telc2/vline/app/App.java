package com.example.telc2.vline.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by TELC2 on 9/21/2017.
 */

public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this.getApplicationContext();
    }

    public static Context getmContext() {
        return mContext;
    }
}

