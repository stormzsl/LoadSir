package com.didiglobal.android.standed.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者:created by storm
 * 自定义View系列相关必看：https://www.jianshu.com/p/158736a2549d
 */

public class CustomViewGroup extends ViewGroup {

    private static final String TAG = CustomViewGroup.class.getSimpleName();

    public CustomViewGroup(Context context) {
        super(context);
        Log.e(TAG,"CustomViewGroup constructor1");
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.e(TAG,"CustomViewGroup constructor2");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //主动调用所有子view测量

        Log.e(TAG,"onMeasure");
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY) {
            Log.e(TAG, "widthMode==MeasureSpec.EXACTLY&&heightMode==MeasureSpec.EXACTLY");
        } else if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.EXACTLY) {
            Log.e(TAG, "widthMode==MeasureSpec.AT_MOST&&heightMode==MeasureSpec.EXACTLY");

        } else if (widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.AT_MOST) {
            Log.e(TAG, "widthMode==MeasureSpec.EXACTLY&&heightMode==MeasureSpec.AT_MOST");
        }
        Log.e(TAG, String.format("widthMode=%d,width=%d,heightMode=%d,height=%d", widthMode, width, heightMode, height));

    }

    //在onLayout中只能使用getMeasuredWidth,而不能使用getWidth,因为getWidth=mRight-mLeft,此时mRight,mLeft相关属性还未赋值呢，
    //详情可参考:https://www.jianshu.com/p/158736a2549d
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.e(TAG,"onLayout");
        for (int index = 0; index < getChildCount(); index++) {
            View child = getChildAt(index);
            int measuredWidth = child.getMeasuredWidth();
            int measureHeight = child.getMeasuredHeight();
            int width = child.getWidth();
            int height = child.getHeight();
            Log.e(TAG, String.format("measuredWidth:%d,measureHeight=%d,width=%d,height=%d", measuredWidth, measureHeight, width, height));
            int left = (r - measuredWidth) / 2;
            int top = (t - measureHeight) / 2;
            int right = left + measuredWidth;
            int bottom = measureHeight + top;
            child.layout(left, top, right, bottom);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG,"onDraw");
    }
}
