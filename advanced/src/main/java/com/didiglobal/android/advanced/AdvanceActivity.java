package com.didiglobal.android.advanced;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.didiglobal.android.advanced.hook.HookViewClickActivity;
import com.didiglobal.android.advanced.monitor.FrameMonitor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 作者:created by storm
 */

public class AdvanceActivity extends AppCompatActivity {

    private View rootView;

    private static final String TAG=AdvanceActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance);
        FrameMonitor monitor = new FrameMonitor();
        monitor.caculateFrame();
        rootView=findViewById(R.id.viewroot);
        int maxLevel=calculateViewTreeTotalLevel(rootView);
        Log.e(TAG,"rootview maxLevel is="+maxLevel);
    }

    public void hookViewClick(View view) {
        Intent intent = new Intent(this, HookViewClickActivity.class);
        startActivity(intent);
    }

    public void collectMethodStackClick(View view) {
        Intent intent = new Intent(this, CollectMethodStackActivity.class);
        startActivity(intent);
    }

    //计算View树层级总数
    private int calculateViewTreeTotalLevel(View view) {
        if (!(view instanceof ViewGroup)) {
            return 1;
        }

        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() == 0) {
            return 1;
        }

        int maxLevel = 0;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childView = viewGroup.getChildAt(i);
            int childViewLevel = calculateViewTreeTotalLevel(childView)+1;
            if (childViewLevel > maxLevel) {
                maxLevel = childViewLevel;
            }
        }

        return maxLevel;
    }

}
