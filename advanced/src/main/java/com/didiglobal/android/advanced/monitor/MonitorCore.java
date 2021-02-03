package com.didiglobal.android.advanced.monitor;

import android.util.Log;
import android.util.Printer;

/**
 * 作者:created by storm
 */

public class MonitorCore implements Printer {

    private StackSampler mStackSampler;

    private static final String TAG=MonitorCore.class.getSimpleName();

    protected MonitorCore() {
        mStackSampler = new StackSampler();
        mStackSampler.init();
    }

    public void startDump(){
        if(mStackSampler==null){
            return;
        }
        mStackSampler.startDump();
    }

    public void stopDump(){
        if (mStackSampler==null){
            return;
        }

        mStackSampler.stopDump();
    }

    @Override
    public void println(String message) {
        Log.e(TAG,message);
    }
}
