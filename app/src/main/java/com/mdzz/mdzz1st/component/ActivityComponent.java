package com.mdzz.mdzz1st.component;

import android.app.Activity;

import com.mdzz.mdzz1st.MainActivity;
import com.mdzz.mdzz1st.activity.WelcomeActivity;
import com.mdzz.mdzz1st.module.ActivityModule;
import com.mdzz.mdzz1st.module.AppModule;

import dagger.Component;

/**
 * Created by Raymond on 2016/11/16.
 */

@Component(modules = {ActivityModule.class,AppModule.class})
public interface ActivityComponent {

    Activity getActivity();

    void inject(WelcomeActivity welcomeActivity);

    void inject(MainActivity mainActivity);
}

