package com.didiglobal.android.standed;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 作者:created by storm
 * 处理Activity的启动模式
 * 参考:https://blog.csdn.net/sinat_14849739/article/details/78072401
 * 1.Activity设置LaunchMode为singInstance时，又被成为单实例模式，多次启动不会创建多个任务栈，全局只会复用一个任务栈并执行Activity的onNewIntent方法。
 * 启动模式为singleInstance的Activity A启动一个standed的Activity B,B会存放在启动A之前的任务栈中.
 *
 * 2.Activity A设置LaunchMode为singTask时，启动A时如果当前任务栈中存在A,会将A实例对象放在当前任务栈中，并清除任务栈中A之上的所有Activity实例，并调用onNewIntent,
 * 如果任务栈中不存在当前任务栈中将新建A对象存在该任务栈栈顶。
 * 另外singtask模式是否需要新建task任务栈，取决于taskaffinty的值，默认是包名，但是如果清单文件中设置了taskaffinty属性不是包名那么会新建值为taskaffinty的task.
 */

public class LaunchModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode);
        Log.e(getClass().getSimpleName(), "onCreate");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(getClass().getSimpleName(), "onNewIntent");
    }

    public void launchModeClick(View view) {
        Intent intent = new Intent(this, LaunchModeActivity.class);
        startActivity(intent);
        Log.e(getClass().getSimpleName(), "launchModeClick");
    }

    public void launchStandModeClick(View view) {
        Intent intent = new Intent(this, StandedActivity.class);
        startActivity(intent);
    }
}
