package com.mdzz.mdzz1st.application;

import android.app.Application;

import com.mdzz.mdzz1st.module.AppModule;

/**
 * Created by Raymond on 2016/11/15.
 *
 * 替换了的Application类，做了点操作而已。
 */

public class MDZZApplication extends Application {

    private AppModule appModule;

    @Override
    public void onCreate() {
        super.onCreate();
        appModule = new AppModule(this);
    }

    public AppModule getAppModule() {
        return appModule;
    }

    public void setAppModule(AppModule appModule) {
        this.appModule = appModule;
    }
}
