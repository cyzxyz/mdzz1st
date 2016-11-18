package com.mdzz.mdzz1st.base;

/**
 * Created by Raymond on 2016/11/15.
 *
 * 我也不知道干啥的
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}
