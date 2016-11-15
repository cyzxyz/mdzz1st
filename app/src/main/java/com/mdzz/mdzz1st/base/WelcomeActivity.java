package com.mdzz.mdzz1st.base;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.mdzz.mdzz1st.R;

/**
 * @author 小侨
 * @time 2016/11/14  16:15
 * @desc ${TODD}
 */

public class WelcomeActivity extends AppCompatActivity {

    private ImageView mImageViewDictionaryIcon;
    private ImageView mImageViewIdiomIcon;
    private ImageView mImageViewTransitionIcon;
    private int mScreenWidth;
    private int mScreenHeight;
    private int mScreenCenterX;
    private int mScreenCenterY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initView();
        setAnimation();
    }

    private void initView() {
        mImageViewDictionaryIcon = (ImageView) findViewById(R.id.imageViewDictionaryIcon);
        mImageViewIdiomIcon = (ImageView) findViewById(R.id.imageViewIdiomIcon);
        mImageViewTransitionIcon = (ImageView) findViewById(R.id.imageViewTransitionIcon);

        mScreenWidth = getWindowManager().getDefaultDisplay().getWidth(); // 屏幕宽
        mScreenHeight = getWindowManager().getDefaultDisplay().getHeight(); // 屏幕高
        mScreenCenterX = mScreenWidth / 2;
        mScreenCenterY = mScreenHeight / 2;
    }

    private void setAnimation() {
        ObjectAnimator translationAnimator1 = ObjectAnimator.ofFloat(
                mImageViewDictionaryIcon, "translationY",
                mScreenCenterX, mScreenCenterY, mScreenCenterX, mScreenCenterY - mScreenCenterY / 2);
        translationAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator translationAnimator2 = ObjectAnimator.ofFloat(
                mImageViewTransitionIcon, "translationY",
                mScreenCenterX, mScreenCenterY, mScreenCenterX, mScreenCenterY + mScreenCenterY / 2);
        translationAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator rotationAnimator1 = ObjectAnimator.ofFloat(
                mImageViewDictionaryIcon, "rotation", 0, 360, 0);
        ObjectAnimator rotationAnimator2 = ObjectAnimator.ofFloat(
                mImageViewTransitionIcon, "rotation", 0, 360, 0);

        AnimatorSet set1 = new AnimatorSet();
        // set1.playSequentially(translationAnimator1, rotationAnimator1); // 顺序播放
        set1.playTogether(translationAnimator1, rotationAnimator1); // 一起播放
        set1.setDuration(3000);
        AnimatorSet set2 = new AnimatorSet();
        set2.playTogether(translationAnimator2, rotationAnimator2); // 一起播放
        set2.setDuration(3000);

        set1.start();
        set2.start();
    }
}
