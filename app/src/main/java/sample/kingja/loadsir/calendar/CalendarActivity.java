package sample.kingja.loadsir.calendar;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import sample.kingja.loadsir.R;

/**
 * 作者:created by storm
 */

public class CalendarActivity extends AppCompatActivity {

    private TextView mTvShow;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        mTvShow=findViewById(R.id.tv_show);
        mTvShow.setText("11/08-16/08");
    }

    public void openCalendarView(View view) {
        //1.跳转日历主界面
//        Intent intent = new Intent();
//        intent.setComponent(new ComponentName("com.android.calendar",
//                "com.android.calendar.LaunchActivity"));
//        startActivity(intent);

        //2.跳转日历添加事件界面,可以添加定时功能
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setData(CalendarContract.Events.CONTENT_URI);
        startActivity(intent);
    }
}
