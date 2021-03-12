package com.didiglobal.android.advanced.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * 作者:created by storm
 */

public class CustomButton extends androidx.appcompat.widget.AppCompatButton {

    private static final String TAG=CustomButton.class.getSimpleName();

    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(100,100);
        Log.e(TAG,"onMeasure");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e(TAG,"OonLayout:"+String.format("changed=%b,left=%d,top=%d,right=%d,bottom=%d",changed,left,top,right,bottom));
    }

    /*
     * 无论返回true还是flase onclick事件都不会执行，因为super.onTouchEvent(event);没有执行，所以内部的onClick事件没有调用
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
