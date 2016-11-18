package com.mdzz.mdzz1st.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.mdzz.mdzz1st.application.MDZZApplication;
import com.mdzz.mdzz1st.http.RetorfitClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Raymond on 2016/11/15.
 */

@Module
public class AppModule {

    MDZZApplication mMDZZApplication;
    SharedPreferences sharedPreferences;
    RetorfitClient retorfitClient;
    public AppModule(MDZZApplication application) {
        mMDZZApplication = application;
        sharedPreferences =  PreferenceManager.getDefaultSharedPreferences(mMDZZApplication);
        retorfitClient = new RetorfitClient();
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mMDZZApplication;
    }


    @Provides
    SharedPreferences providesSharedPreferences() {
        return sharedPreferences;
    }

    @Provides
    @Singleton
    RetorfitClient providesRetorfitClient() {
        return retorfitClient;
    }

}
