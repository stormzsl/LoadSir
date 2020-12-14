package com.didiglobal.android.standed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.didiglobal.android.standed.animation.FrameAnimationActivity;
import com.didiglobal.android.standed.animation.ObjectAnimationActivity;
import com.didiglobal.android.standed.animation.TweenAnimationActivity;
import com.didiglobal.android.standed.animation.valueanimation.ValueAnimatorActivity;
import com.didiglobal.android.standed.launchmode.LaunchModeActivity;
import com.didiglobal.android.standed.view.MeasureViewActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 作者:created by storm
 */

public class StandedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standed);
    }

    public void launchModeClick(View view) {
        Intent intent = new Intent(this, LaunchModeActivity.class);
        startActivity(intent);
    }

    public void tweenAnimationClick(View view) {
        Intent intent = new Intent(this, TweenAnimationActivity.class);
        startActivity(intent);
    }

    public void frameAnimationClick(View view) {
        Intent intent = new Intent(this, FrameAnimationActivity.class);
        startActivity(intent);
    }

    public void valueAnimationClick(View view) {
        Intent intent = new Intent(this, ValueAnimatorActivity.class);
        startActivity(intent);
    }

    public void objectAnimationClick(View view) {
        Intent intent = new Intent(this, ObjectAnimationActivity.class);
        startActivity(intent);
    }

    public void MeasureViewClick(View view) {
        Intent intent = new Intent(this, MeasureViewActivity.class);
        startActivity(intent);
    }
}
