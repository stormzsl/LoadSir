package com.didiglobal.android.standed.animation.valueanimation;

import android.animation.TypeEvaluator;

/**
 * 作者:created by storm
 * 自定义估值器确定变化的值
 */

public class CircleViewTypeEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        //fraction是动画完成度值，如果是线性插值器又成为匀速插值器，那么该值是当前动画展示时间/设置动画duration时间
        //fraction的值是插值器interpolator的方法getInterpolation()的返回值
        int changeX = (int) (startValue.getX() + fraction * (endValue.getX() - startValue.getX()));
        int changeY = (int) (startValue.getY() + fraction * (endValue.getY() - startValue.getY()));
        return new Point(changeX, changeY);
    }
}
