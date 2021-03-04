package com.didiglobal.android.advanced.exception;

import android.util.Log;

/**
 * 作者:created by storm
 */

public class ThreadCatchException implements Thread.UncaughtExceptionHandler {

    private static String TAG=ThreadCatchException.class.getSimpleName();
    @Override
    public void uncaughtException(Thread t, Throwable e) {

        Log.e(TAG,String.format("thread name:"+t.getName()));
        for (StackTraceElement stackTraceElement : t.getStackTrace()) {
            Log.e(TAG,String.format("stacktrace:%s",stackTraceElement.toString()));
        }
        Log.e(TAG,"throwable:"+e.toString());

    }
}
