package com.didiglobal.android.standed.animation;

import android.os.Bundle;
import android.view.animation.TranslateAnimation;

import com.didiglobal.android.standed.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 作者:created by storm
 * 补间动画:平移，旋转，缩放，透明度变化
 */

public class TweenAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tween_animation_activity);
    }
}
