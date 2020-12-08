package com.didiglobal.android.advanced.hook;

import android.content.Context;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 作者:created by storm
 */

public class HookClickUtils {

    public static void hookViewClick(Context context, View view) {
        try {
            Method getListenerInfoMethod = View.class.getDeclaredMethod("getListenerInfo");
            getListenerInfoMethod.setAccessible(true);

            //1.获取View的属性变量值ListenerInfo对象
            Object listenerInfoObj = getListenerInfoMethod.invoke(view);
            //2.获取ListenerInfo对象中的mOnClickListener成员变量
            Field onClickListenerField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            onClickListenerField.setAccessible(true);
            Object mOnClickListener = onClickListenerField.get(listenerInfoObj);

            //3.创建hook对象mProxyOnClickListener
            Object hookClickListener=Proxy.newProxyInstance(context.getClassLoader(), new Class[]{View.OnClickListener.class}, new ViewClickInvocationHandler(mOnClickListener));

            //4.使用hook对象替换ListenerInfo中的mOnClickListener成员变量
            onClickListenerField.set(listenerInfoObj,hookClickListener);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("HookClickUtils error:", e.getMessage());
        }
    }

    static class ViewClickInvocationHandler implements InvocationHandler {
        private Object srcOnClickListener;

        public ViewClickInvocationHandler(Object srcOnClickListener) {
            this.srcOnClickListener = srcOnClickListener;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (srcOnClickListener == null) {
                return null;
            }
            Object result = method.invoke(srcOnClickListener, args);
            Log.e("ViewClick", "click");
            return result;
        }
    }
}
