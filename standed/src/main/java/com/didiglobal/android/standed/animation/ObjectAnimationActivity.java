package com.didiglobal.android.standed.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

import com.didiglobal.android.standed.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 作者:created by storm
 * ValueAnimator与ObjectAnimator的区别
 * 1.ObjectAnimator继承自ValueAnimator
 * 2.ValueAnimator是通过值的不断改变，手动操作修改对象属性从而实现动画，它是间接实现动画效果。
 * 3.ObjectAnimator也是通过值的不断改变，不过是自动修改对象的属性实现的动画，它是直接操作对象。
 *
 * 估值器与插值器是自定义复杂动画的基础
 * 插值器:确定起始值到结束值变化的趋势，如匀速，加速，减速等，系统内置了插值器大部分可以满足需求，
 * 同时也可以自定义插值器，只需实现Interpolator接口即可。
 *
 * 估值器：确定值变化的最终值，系统内置的IntElevator,FloatElevator可以满足整型/浮点型的估值器，也可以自定义估值器
 * 需要实现TypeElevator接口即可
 */

public class ObjectAnimationActivity extends AppCompatActivity implements View.OnClickListener {


    private Button mBtControl;

    private Button mBtSystemInterpolator;
    private Button mBtCustomInterpolator;

    private static final String TAG=ObjectAnimationActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.object_animation_activity);
        mBtControl=findViewById(R.id.bt_object_animation);
        mBtSystemInterpolator=findViewById(R.id.bt_system_interpolator);
        mBtCustomInterpolator=findViewById(R.id.bt_custom_interpolator);
        initView();
    }

    private void initView() {
        mBtControl.setOnClickListener(this);
        mBtSystemInterpolator.setOnClickListener(this);
        mBtCustomInterpolator.setOnClickListener(this);
    }

    //使用系统的插值器or自定义插值器
    private void interpolatorSystemLogic() {
        AlphaAnimation alphaAnimation=new AlphaAnimation(1.0f,0.0f);
        Interpolator interpolator=new OvershootInterpolator();
        alphaAnimation.setDuration(2000);
        alphaAnimation.setInterpolator(interpolator);
        alphaAnimation.setFillBefore(true);
        mBtSystemInterpolator.startAnimation(alphaAnimation);
    }

    //使用自定义插值器
    private void interpolatorCustomLogic(){
        TranslateAnimation translateAnimation=new TranslateAnimation(0,400,0,-200);
        translateAnimation.setFillAfter(false);
        translateAnimation.setInterpolator(new CustomInterpolator());
        translateAnimation.setDuration(2000);
        mBtCustomInterpolator.startAnimation(translateAnimation);
    }

    private void ObjectAnimationLogic(){
        float translationX=mBtControl.getTranslationX();
        float x=mBtControl.getX();
        float width=mBtControl.getWidth();
        float getLeft=mBtControl.getLeft();
        Log.e(TAG,String.format("left=%f,translationX=%f,x=%f,width=%f",getLeft,translationX,x,width));
       ValueAnimator valueAnimator= ObjectAnimator.ofFloat(mBtControl,"translationX",translationX,200,translationX);
       valueAnimator.setDuration(2000);
       valueAnimator.start();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bt_system_interpolator){
            interpolatorSystemLogic();
        }else if(v.getId()==R.id.bt_custom_interpolator){
            interpolatorCustomLogic();
        }else if(v.getId()==R.id.bt_object_animation){
            ObjectAnimationLogic();
        }
    }

    //自定义插值器
    class CustomInterpolator implements Interpolator{
        @Override
        public float getInterpolation(float input) {
            return (float)(Math.sin(2* Math.PI * input));
        }
    }
}
