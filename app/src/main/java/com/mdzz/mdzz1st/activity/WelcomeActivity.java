package com.mdzz.mdzz1st.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.mdzz.mdzz1st.MainActivity;
import com.mdzz.mdzz1st.R;
import com.mdzz.mdzz1st.application.MDZZApplication;
import com.mdzz.mdzz1st.base.BaseActivity;
import com.mdzz.mdzz1st.component.ActivityComponent;


import com.mdzz.mdzz1st.component.DaggerActivityComponent;
import com.mdzz.mdzz1st.module.ActivityModule;
import com.mdzz.mdzz1st.presenter.WelcomePresenter;
import com.mdzz.mdzz1st.presenter.contract.WelcomeContract;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 小侨
 * @time 2016/11/14  16:15
 * @desc ${TODD}
 */

public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements WelcomeContract.View {

    private static final String TAG = "AppCompatActivity";

    @BindView(R.id.imageViewDictionaryIcon)
    ImageView mImageViewDictionaryIcon;

    @BindView(R.id.imageViewIdiomIcon)
    ImageView mImageViewIdiomIcon;

    @BindView(R.id.imageViewTransitionIcon)
    ImageView mImageViewTransitionIcon;

    private int mScreenWidth;
    private int mScreenHeight;
    private int mScreenCenterX;
    private int mScreenCenterY;




    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initEventAndData() {
        initView();
        setAnimation();
    }

    private void initView() {
        mScreenWidth = getWindowManager().getDefaultDisplay().getWidth(); // 屏幕宽
        mScreenHeight = getWindowManager().getDefaultDisplay().getHeight(); // 屏幕高
        mScreenCenterX = mScreenWidth / 2;
        mScreenCenterY = mScreenHeight / 2;
        Log.v(TAG, "1:" + mScreenCenterX + "   2:" + mScreenCenterY);
    }

    private void setAnimation() {
        ObjectAnimator translationAnimator1 = ObjectAnimator.ofFloat(
                mImageViewDictionaryIcon, "translationY", -mScreenCenterY / 2);
        translationAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator translationAnimator2 = ObjectAnimator.ofFloat(
                mImageViewTransitionIcon, "translationY", mScreenCenterY / 2);
        translationAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator rotationAnimator1 = ObjectAnimator.ofFloat(
                mImageViewDictionaryIcon, "rotation", 0, 360, 0);
        ObjectAnimator rotationAnimator2 = ObjectAnimator.ofFloat(
                mImageViewTransitionIcon, "rotation", 0, 360, 0);
        ObjectAnimator rotationAnimator3 = ObjectAnimator.ofFloat(
                mImageViewIdiomIcon, "rotation", 0, 360, 0);
        rotationAnimator3.setDuration(3000);

        AnimatorSet set1 = new AnimatorSet();
        // set1.playSequentially(translationAnimator1, rotationAnimator1); // 顺序播放
        set1.playTogether(translationAnimator1, rotationAnimator1); // 一起播放
        set1.setDuration(3000);
        AnimatorSet set2 = new AnimatorSet();
        set2.playTogether(translationAnimator2, rotationAnimator2);
        set2.setDuration(3000);

        set1.start();
        set2.start();
        rotationAnimator3.start();

        rotationAnimator3.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1500);
                            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    @Override
    public void showError(String msg) {

    }


    protected ActivityComponent getActivityComponent(){
        return  DaggerActivityComponent.builder()
                .appModule(((MDZZApplication)getApplication()).getAppModule())
                .activityModule(getActivityModule())
                .build();

    }

    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    @Override
    public void showContent() {

    }
}
