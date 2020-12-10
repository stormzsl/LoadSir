package com.didiglobal.android.standed.animation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.didiglobal.android.standed.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 作者:created by storm
 * 在android 3.0以后增加了ValueAnimator和ObjectAnimator来扩展帧动画和补间动画只适用于View的不足，属性动画可以作用于任何对象，
 * 原理:根据在一段时间内起始值到结束值值的变化，来修改view的属性或者其他的任何逻辑，不再仅仅局限于View
 * 不同于补间动画和帧动画不能改变view的属性，而ValueAnimator操作View时可以改变View的属性.
 * 每次赋值View属性都会调用invalidate方法刷新ui，回调View的onDraw，从而实现动画效果。
 * ValueAnimator.ofInt（int values）
 * ValueAnimator.ofFloat（float values）
 * ValueAnimator.ofObject（int values）
 *
 * 插值器:是设置值变化的趋势比如加速，减速等,自定义插值器实现Interpolator接口
 * 估值器：设置值变化的具体数值，需要自定义实现TypeEvaluator接口,比如整型估值器IntEvaluator
 *
 */

public class ValueAnimatorActivity extends AppCompatActivity {

    private Button mBtDesc;

    private Button mBtControl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.value_animation_activity);
        mBtDesc = findViewById(R.id.bt_desc);
        mBtControl = findViewById(R.id.bt_control);
        mBtDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("ValueAnimatorActivity",String.format("X=%f,Y=%f",mBtDesc.getX(),mBtDesc.getY()));
                Toast.makeText(ValueAnimatorActivity.this, "btdesc click", Toast.LENGTH_SHORT).show();
            }
        });

        mBtControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 400);
                valueAnimator.setDuration(2000);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value = (float) animation.getAnimatedValue();
                        mBtDesc.setX(value);
                    }
                });
                valueAnimator.start();
            }
        });
    }
}
