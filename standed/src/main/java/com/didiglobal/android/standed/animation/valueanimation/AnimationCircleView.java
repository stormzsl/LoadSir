package com.didiglobal.android.standed.animation.valueanimation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

/**
 * 作者:created by storm
 * 1.自定义View继承View时如果没有重写onMeasure()设置View的高度,那么布局中自定义View设置wrap_content属性时与父View的宽高一样，
 * 等同于设置View的宽高为match_parent
 *
 * 2.设置父View的布局属性padding时会影响自定义View的宽高,此时View的宽=parentWidth-paddingLeft-paddingRight.
 *
 */

public class AnimationCircleView extends View {

    private Paint mPaint;//画笔

    private float radius=70;//圆直径

    private Point mCurrentPoint;//当前位置

    private int screenWith;

    private int screenHeight;

    private final static String TAG=AnimationCircleView.class.getSimpleName();
    public AnimationCircleView(Context context) {
        super(context);
        init(context,null);

    }

    public AnimationCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    private void init(Context context,AttributeSet attributeSet){
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        screenWith=context.getResources().getDisplayMetrics().widthPixels;
        screenHeight=context.getResources().getDisplayMetrics().heightPixels;
        //adb shell wm size => 720x1280
        Log.e(TAG,String.format("screenWith=%s,screenHeight=%s",screenWith,screenHeight));
        if(attributeSet!=null){
            for (int index = 0; index < attributeSet.getAttributeCount(); index++) {
                String attributeName=attributeSet.getAttributeName(index);
                String attributeValue=attributeSet.getAttributeValue(index);
                Log.e(TAG,String.format("attributeName=%s,attributeValue=%s",attributeName,attributeValue));
            }
        }

    }

    /*
     * 两次调用onMeasure why?
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //高两位代表measureMode,低30位代表measureSize
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int width=MeasureSpec.getSize(widthMeasureSpec);

        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
        int height=MeasureSpec.getSize(heightMeasureSpec);
        ViewGroup parent= (ViewGroup) getParent();
        if(widthMode==MeasureSpec.EXACTLY&&heightMeasureSpec==MeasureSpec.EXACTLY){
            Log.e(TAG,String.format("width/height mode is exactly,parentWidth=%d,parentHeight=%d,width=%d,height=%d",parent.getWidth(),parent.getHeight(),width,height));
        }else if(widthMode==MeasureSpec.EXACTLY){
            Log.e(TAG,String.format("width mode is exactly,parentWidth=%d,parentHeight=%d,width=%d,height=%d",parent.getWidth(),parent.getHeight(),width,height));
        }else if(heightMode==MeasureSpec.EXACTLY){
            Log.e(TAG,String.format("height mode is exactly,parentWidth=%d,parentHeight=%d,width=%d,height=%d",parent.getWidth(),parent.getHeight(),width,height));
        }else {
            Log.e(TAG,String.format("width/height all not exactly,parentWidth=%d,parentHeight=%d,width=%d,height=%d",parent.getWidth(),parent.getHeight(),width,height));
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e(TAG,String.format("onLayout changed=%s,left=%d,top=%d,right=%d,bottom=%d",changed,left,top,right,bottom));
        ViewGroup parent= (ViewGroup) getParent();
        Log.e(TAG,String.format("onLayout view's getParentWidth=%d,getParentHeight=%d,width=%d,height=%d",parent.getWidth(),parent.getHeight(),getWidth(),getHeight()));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG,"onDraw >>>>>");
        ViewGroup parent= (ViewGroup) getParent();
        if(mCurrentPoint==null){
            mCurrentPoint=new Point(100,100);//起始位置坐标(100,100)
            canvas.drawCircle(mCurrentPoint.getX(),mCurrentPoint.getY(),radius,mPaint);
            Point startPoint=new Point(100,100);
            Point endPoint=new Point(parent.getWidth()-200, parent.getHeight()-200);
            ValueAnimator valueAnimator=ValueAnimator.ofObject(new CircleViewTypeEvaluator(),startPoint,endPoint);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mCurrentPoint= (Point) animation.getAnimatedValue();
                    invalidate();
                }
            });
            valueAnimator.setDuration(5000);
            valueAnimator.start();
        }else {
            canvas.drawCircle(mCurrentPoint.getX(),mCurrentPoint.getY(),radius,mPaint);
//            invalidate();
        }
    }
}
