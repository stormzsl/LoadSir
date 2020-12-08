package com.didiglobal.android.advanced.hook;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.didiglobal.android.advanced.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 作者:created by storm
 * hook系统的view click事件，为click事件中增加log输出
 */

public class HookViewClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hook_view_click);
        initView();
    }

    private void initView() {
        Button mHookBt = findViewById(R.id.hookBt);
        mHookBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HookViewClickActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });
        HookClickUtils.hookViewClick(this,mHookBt);
    }
}
