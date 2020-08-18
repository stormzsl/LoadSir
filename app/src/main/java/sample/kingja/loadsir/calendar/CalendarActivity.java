package sample.kingja.loadsir.calendar;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import sample.kingja.loadsir.R;
import sample.kingja.loadsir.week.WeekShowActivity;

/**
 * 作者:created by storm
 */

public class CalendarActivity extends AppCompatActivity {

    private Button mOpenWeekBt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        mOpenWeekBt=findViewById(R.id.openWeekActivity);
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

    public void openWeekActivity(View view){
        Intent intent=new Intent(this, WeekShowActivity.class);
        startActivity(intent);
    }
}
