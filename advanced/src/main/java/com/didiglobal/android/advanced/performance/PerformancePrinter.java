package com.didiglobal.android.advanced.performance;

import android.util.ArrayMap;
import android.util.Log;
import android.util.Printer;

import java.util.HashSet;
import java.util.TreeMap;

/**
 * 作者:created by storm
 */

public class PerformancePrinter implements Printer {

    private static final String TAG= PerformancePrinter.class.getSimpleName();

    private HashSet<String> messageSet=new HashSet<>();

    /*
     *  E/PerformancePrinter: >>>>> Dispatching to Handler (android.view.Choreographer$FrameHandler) {b2f9ccc} android.view.Choreographer$FrameDisplayEventReceiver@6d41b15: 0
2021-03-04 17:27:08.326 16895-16895/sample.kingja.loadsir E/PerformancePrinter: <<<<< Finished to Handler (android.view.Choreographer$FrameHandler) {b2f9ccc} android.view
     */
    @Override
    public void println(String message) {
        if(!messageSet.contains(message)){
            Log.e(TAG,message);
            printThreadStackTrace();
        }
        messageSet.add(message);
    }

    private void printThreadStackTrace(){
        Thread thread=Thread.currentThread();
        for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
            Log.e(TAG,"stacktrace:"+stackTraceElement.toString());
        }
    }
}
