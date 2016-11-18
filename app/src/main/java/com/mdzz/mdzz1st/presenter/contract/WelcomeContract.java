package com.mdzz.mdzz1st.presenter.contract;



import com.mdzz.mdzz1st.base.BasePresenter;
import com.mdzz.mdzz1st.base.BaseView;

/**
 * Created by Raymond on 2016/11/16.
 */

public interface WelcomeContract {
    interface View extends BaseView{
        void showContent();
    }
    interface Presenter extends BasePresenter<View>{

    }
}
