package com.didiglobal.android.standed.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        Log.e(TAG + " tv1", String.format(getResources().getString(R.string.print_width_height), tv1.getWidth(), tv1.getHeight()));

        Log.e(TAG + " tv2", String.format(getResources().getString(R.string.print_width_height), tv2.getWidth(), tv2.getHeight()));

        Log.e(TAG + " layout3", String.format(getResources().getString(R.string.print_width_height), layout3.getWidth(), layout3.getHeight()));

        Log.e(TAG + " tv3", String.format(getResources().getString(R.string.print_width_height), tv3.getWidth(), tv3.getHeight()));
    }
}
