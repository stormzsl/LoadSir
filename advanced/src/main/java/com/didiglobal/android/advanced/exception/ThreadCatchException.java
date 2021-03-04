package com.didiglobal.android.advanced.exception;

import android.content.Context;
import android.util.Log;

/**
 * 作者:created by storm
 */

public class ThreadCatchException implements Thread.UncaughtExceptionHandler {

    private static String TAG=ThreadCatchException.class.getSimpleName();

    private Context mContext;
    private static ThreadCatchException INSTANCE = new ThreadCatchException();
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    public static ThreadCatchException getInstance() {
        return INSTANCE;
    }

    public void init(Context ctx) {
        mContext = ctx.getApplicationContext();
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        Log.e(TAG,String.format("thread name:"+t.getName()));
        for (StackTraceElement stackTraceElement : t.getStackTrace()) {
            Log.e(TAG,String.format("stacktrace:%s",stackTraceElement.toString()));
        }
        Log.e(TAG,"throwable:"+e.toString());
        mDefaultHandler.uncaughtException(t, e);    //该代码不执行的话程序无法终止

    }
}
