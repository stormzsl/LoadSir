package com.didiglobal.android.standed.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.didiglobal.android.standed.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 作者:created by storm
 */

public class MeasureViewActivity extends AppCompatActivity {

    private final static String TAG = MeasureViewActivity.class.getSimpleName();

    private ViewGroup rootLayout;
    private ViewGroup layout1;
    private ViewGroup layout2;
    private TextView tv1;
    private TextView tv2;
    private ViewGroup layout3;
    private TextView tv3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure_view);
        initView();
        printWindowManagerHashCode();
    }

    /*构建Toast时需要looper，当需要在子线程中调用handler时记得要调用 Looper.prepare
     */
    private void testToast(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Toast toast=new Toast(MeasureViewActivity.this);
                Log.e(TAG,"constructor toast need looper ");
            }
        }).start();
    }

    /*
     *构造Dialog的Context必须为Activity实例，否则会在ViewRootImpl.setView()类中抛出BadTokenException异常
     */
    private void testDialog(){
        TextView textView=new TextView(MeasureViewActivity.this);
        Dialog dialog=new Dialog(MeasureViewActivity.this.getApplicationContext());
        dialog.setContentView(textView);
        dialog.show();
    }

    /*
     *调用Context获取WindowManager时生成的是同一个WindowManager
     * 一个Activity对应一个Window,一个Window对应一个WindowManager,Window调用setWindowManager关联WindowManager
     */
    private void printWindowManagerHashCode(){
        WindowManager windowManager= (WindowManager) MeasureViewActivity.this.getSystemService(Context.WINDOW_SERVICE);
        Log.e("windowManager111",String.valueOf(windowManager.hashCode()));
    }

    private void initView() {
        rootLayout=findViewById(R.id.root_layout);
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        layout3 = findViewById(R.id.layout3);
        tv3 = findViewById(R.id.tv3);

        tv3.post(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG,">>>>>>>");
                printViewSize();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        printViewSize();
    }

    public void getViewSize(View view) {
        printViewSize();
    }

    private void printViewSize() {
        Log.e(TAG + " rootLayout", String.format(getResources().getString(R.string.print_width_height), rootLayout.getWidth(), rootLayout.getHeight()));

        Log.e(TAG + " layout1", String.format(getResources().getString(R.string.print_width_height), layout1.getWidth(), layout1.getHeight()));

        Log.e(TAG + " layout2", String.format(getResources().getString(R.string.print_width_height), layout2.getWidth(), layout2.getHeight()));

        Handler handler=new Handler();
        //这个任务的执行是放在消息队列中的尾部，等待Looper循环执行到此处取到消息才能继续执行MeasureViewActivity
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG,"handler.postDelayed begin excute");
            }
        },0);
        Log.e(TAG + " tv1", String.format(getResources().getString(R.string.print_width_height), tv1.getWidth(), tv1.getHeight()));

        Log.e(TAG + " tv2", String.format(getResources().getString(R.string.print_width_height), tv2.getWidth(), tv2.getHeight()));

        Log.e(TAG + " layout3", String.format(getResources().getString(R.string.print_width_height), layout3.getWidth(), layout3.getHeight()));

        Log.e(TAG + " tv3", String.format(getResources().getString(R.string.print_width_height), tv3.getWidth(), tv3.getHeight()));
    }
}
