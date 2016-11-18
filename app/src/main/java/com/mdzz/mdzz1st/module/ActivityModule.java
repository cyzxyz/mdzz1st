package com.mdzz.mdzz1st.module;

import android.app.Activity;

import com.mdzz.mdzz1st.http.RetorfitClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Raymond on 2016/11/16.
 */

@Module
public class ActivityModule {
    private Activity mActivity;
    private RetorfitClient mRetrofitClient;
    public ActivityModule(Activity activity) {
        this.mActivity = activity;
        mRetrofitClient = new RetorfitClient();
    }

    @Provides
    public Activity provideActivity() {
        return mActivity;
    }


}