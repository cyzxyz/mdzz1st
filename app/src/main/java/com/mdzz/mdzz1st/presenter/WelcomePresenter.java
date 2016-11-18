package com.mdzz.mdzz1st.presenter;

import android.content.SharedPreferences;
import android.util.Log;

import com.mdzz.mdzz1st.application.MDZZApplication;
import com.mdzz.mdzz1st.base.BasePresenter;
import com.mdzz.mdzz1st.presenter.contract.WelcomeContract;
import com.mdzz.mdzz1st.util.DebugLog;

import javax.inject.Inject;

/**
 * Created by Raymond on 2016/11/16.
 */

public class WelcomePresenter   implements BasePresenter<WelcomeContract.View>, WelcomeContract.Presenter {
    protected WelcomeContract.View mView;
    private   SharedPreferences sharedPreferences;

    @Inject
    public  WelcomePresenter(SharedPreferences sharedPreferences){
       this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void attachView(WelcomeContract.View view) {
        mView = view;
        DebugLog.log(mView.toString());
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
