package com.didiglobal.android.standed.animation;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import com.didiglobal.android.standed.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 作者:created by storm
 * ValueAnimator与ObjectAnimator的区别
 * 1.ObjectAnimator继承自ValueAnimator
 * 2.ValueAnimator是通过值的不断改变，手动操作修改对象属性从而实现动画，它是间接实现动画效果。
 * 3.ObjectAnimator也是通过值的不断改变，不过是自动修改对象的属性实现的动画，它是直接操作对象。
 */

public class ObjectAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.object_animation_activity);

    }
}
