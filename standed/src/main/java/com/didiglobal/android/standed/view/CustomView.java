package com.didiglobal.android.standed.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 作者:created by storm
 */

public class CustomView extends View {


    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //绘制子view调用的方法，默认是空实现
    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /*
    在自定义绘制过程中，需由子类去实现复写该方法，从而绘制自身的内容，默认是空实现，
    由子view决定绘制的内容,自定义View中 必须 且 只需复写onDraw
    */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
