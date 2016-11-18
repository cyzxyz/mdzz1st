package com.mdzz.mdzz1st.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Raymond on 2016/11/15.
 *
 * activity 的 基类，集成activity 中所有基本操作，例如动画，基本绑定流程等。
 * （然而现在啥都没做）
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {

    @Inject
    protected T mPresenter;
    protected Activity mContext;
    private Unbinder mUnBinder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mUnBinder = ButterKnife.bind(this);
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
        mContext = this;
        initEventAndData();
    }




    @Override
    protected void onDestroy() {
        if (mPresenter != null)
            mPresenter.detachView();
        mUnBinder.unbind();
        super.onDestroy();
    }

    protected abstract void initInject();
    protected abstract int getLayout();
    protected abstract void initEventAndData();
}
