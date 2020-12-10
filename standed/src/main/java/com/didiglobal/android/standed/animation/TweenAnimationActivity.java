package com.didiglobal.android.standed.animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.didiglobal.android.standed.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 作者:created by storm
 * 补间动画:平移，旋转，缩放，透明度变化,补间动画和帧动画只能作用于View对象，不能作用其他对象，使用上具有局限性.
 * 补间动画只是改变了View的视觉效果，而不会真正去改变View的属性。
 * 如，将屏幕左上角的按钮 通过补间动画 移动到屏幕的右下角
 * 点击当前按钮位置（屏幕右下角）是没有效果的，因为实际上按钮还是停留在屏幕左上角，
 * 补间动画只是将这个按钮绘制到屏幕右下角，改变了视觉效果而已。
 */

public class TweenAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mTranslateBt;
    private Button mScaleBt;
    private Button mRotateBt;
    private Button mAlphaBt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tween_animation_activity);
        mTranslateBt = findViewById(R.id.bt_translate);
        mScaleBt = findViewById(R.id.bt_scale);
        mRotateBt = findViewById(R.id.bt_rotate);
        mAlphaBt = findViewById(R.id.bt_alpha);

        mTranslateBt.setOnClickListener(this);
        mScaleBt.setOnClickListener(this);
        mRotateBt.setOnClickListener(this);
        mAlphaBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.bt_translate) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, 300, 0, 0);
            translateAnimation.setDuration(1000);
            translateAnimation.setFillAfter(true);//视觉效果保留在动画之后的状态
            mTranslateBt.startAnimation(translateAnimation);
        } else if (id == R.id.bt_scale) {
            ScaleAnimation scaleAnimation=new ScaleAnimation(0f,1.2f,0f,1.2f);
            scaleAnimation.setDuration(1000);
            scaleAnimation.setFillAfter(true);
            mScaleBt.startAnimation(scaleAnimation);
        } else if (id == R.id.bt_rotate) {
            RotateAnimation rotateAnimation=new RotateAnimation(0,360);
            rotateAnimation.setDuration(2000);
            rotateAnimation.setFillAfter(false);
            mRotateBt.startAnimation(rotateAnimation);
        } else if (id == R.id.bt_alpha) {
            AlphaAnimation alphaAnimation=new AlphaAnimation(1.0f,0.0f);
            alphaAnimation.setDuration(2000);
            alphaAnimation.setFillAfter(false);
            mAlphaBt.startAnimation(alphaAnimation);
        }
    }
}
