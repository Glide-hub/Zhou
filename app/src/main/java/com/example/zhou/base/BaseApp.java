package com.example.zhou.base;

import android.app.Application;
import android.content.res.Resources;

public class BaseApp extends Application {
    public static BaseApp sContext =null;


    @Override
    public void onCreate() {
        super.onCreate();
        sContext=this;
    }
    public static Resources getRes() {
        return sContext.getResources();
    }
}
