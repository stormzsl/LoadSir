package com.didiglobal.android.standed.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.didiglobal.android.standed.R;
import com.didiglobal.android.standed.StandedActivity;

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
 *
 * 3.代码中设置FLAG_ACTIVITY_NEW_TASK 比较标准解释如下：
 * 首先会查找是否存在和被启动的Activity具有相同的亲和性的任务栈（即taskAffinity，注意同一个应用程序中的activity的亲和性相同），
 * 如果有，则直接把这个栈整体移动到前台，并保持栈中旧activity的顺序不变，然后被启动的Activity会被压入栈，
 * 如果没有，则新建一个栈来存放被启动的activity，注意，默认情况下同一个应用中的所有Activity拥有相同的关系(taskAffinity).
 *
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
