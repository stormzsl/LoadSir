package com.didiglobal.android.advanced.monitor;

import android.util.Log;
import android.view.Choreographer;

/**
 * 作者:created by storm
 */

public class FrameMonitor {

    private static final String TAG=FrameMonitor.class.getSimpleName();

    private long frameTimeNanosStart;

    private boolean isFirst=true;
    public void caculateFrame(){
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
            @Override
            public void doFrame(long frameTimeNanos) {
                if(isFirst){
                    frameTimeNanosStart=frameTimeNanos;
                    isFirst=false;
                }else {
                    long costTimeMillis=(frameTimeNanos-frameTimeNanosStart)/1000000;
                    Log.e(TAG,"costTime="+costTimeMillis);
                    frameTimeNanosStart=frameTimeNanos;
                }

                Choreographer.getInstance().postFrameCallback(this);
            }
        });
    }
}
