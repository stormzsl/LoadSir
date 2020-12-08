package com.didiglobal.android.advanced;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.didiglobal.android.advanced.hook.HookViewClickActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 作者:created by storm
 */

public class AdvanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance);
    }

    public void hookViewClick(View view) {
        Intent intent = new Intent(this, HookViewClickActivity.class);
        startActivity(intent);
    }

}
