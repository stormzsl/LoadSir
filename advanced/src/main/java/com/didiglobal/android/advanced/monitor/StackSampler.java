package com.didiglobal.android.advanced.monitor;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 作者:created by storm
 */

public class StackSampler {

    private static final String LINE_SEPERATE="\r\n";

    private static final String TAG= StackSampler.class.getSimpleName();

    private HandlerThread handlerThread;

    private Handler handler;

    private AtomicBoolean mRunning=new AtomicBoolean(false);

    private Runnable runnable;

    private long internalTime=500;

    private String mFilterCache;

    public StackSampler(){}

    public void init(){
        if(handlerThread!=null){
            return;
        }
        handlerThread=new HandlerThread("BlockMonitor");
        handlerThread.start();
        handler=new Handler(handlerThread.getLooper());
        runnable=new Runnable() {
            @Override
            public void run() {
                dumpInfo();
                if(mRunning.get()){
                    handler.postDelayed(runnable,internalTime);
                }
            }
        };
    }

    public void startDump(){
        if(mRunning.get()){
            return;
        }
        mRunning.set(true);
        handler.postDelayed(runnable,internalTime);

    }

    public void stopDump(){
        mRunning.set(false);
        if(handlerThread!=null){
            handlerThread.quit();
            handler.removeCallbacks(runnable);
        }
    }

    private void dumpInfo(){
        Thread uiThread= Looper.getMainLooper().getThread();
        StringBuilder stringBuilder=new StringBuilder();
        for (StackTraceElement stackTraceElement : uiThread.getStackTrace()) {
            stringBuilder.append(stackTraceElement.toString()).append(LINE_SEPERATE);
        }
        if(!shouldIgnore(stringBuilder)){
            Log.e(TAG,stringBuilder.toString());
        }
    }

    /**
     * 过滤掉重复项
     *
     * @param builder
     * @return
     */
    private boolean shouldIgnore(StringBuilder builder) {
        if (TextUtils.equals(mFilterCache, builder.toString())) {
            return true;
        }
        mFilterCache = builder.toString();
        return false;
    }
}
