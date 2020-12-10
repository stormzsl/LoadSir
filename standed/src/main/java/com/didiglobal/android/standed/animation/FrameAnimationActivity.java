package com.didiglobal.android.standed.animation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.didiglobal.android.standed.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 作者:created by storm
 * 帧动画:每一帧对应一张图片，多个帧会包含多张图片注意内存溢出的问题
 */

public class FrameAnimationActivity extends AppCompatActivity {

    private ImageView mIvShow;

    private Button mBtPlay;
    private boolean mFlag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_animation_activity);
        mIvShow = findViewById(R.id.iv_show);
        final Drawable backgroundDrawable = mIvShow.getBackground();
        mBtPlay = findViewById(R.id.bt_play_frame);
        mBtPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (backgroundDrawable instanceof AnimationDrawable) {
                    AnimationDrawable animationDrawable = (AnimationDrawable) backgroundDrawable;
                    if (mFlag) {
                        animationDrawable.stop();
                        mFlag = false;
                    } else {
                        animationDrawable.start();
                        mFlag = true;
                    }
                }else {
                    Toast.makeText(FrameAnimationActivity.this,"backgroud drawable is not instance of Animation Drawable",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
