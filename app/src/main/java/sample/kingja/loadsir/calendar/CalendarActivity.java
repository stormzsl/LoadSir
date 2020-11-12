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
//        Intent intent = new Intent(Intent.ACTION_INSERT);
//        intent.setData(CalendarContract.Events.CONTENT_URI);
//        startActivity(intent);
//        try {
//            long morningStartTimeMiles =System.currentTimeMillis()+(24*60*60*1000);
//            long endStartTimeMiles=morningStartTimeMiles+(2*60*60*1000);
//
//            CalendarReminderUtils.addCalendarEvent(this,"早上test","满满的一天开启正能量",morningStartTimeMiles,1);
//            CalendarReminderUtils.addCalendarEvent(this,"晚上test","晚上了要加油",endStartTimeMiles,1);
//            Intent intent = new Intent();
//            intent.setComponent(new ComponentName("com.android.calendar",
//                    "com.android.calendar.LaunchActivity"));
//            startActivity(intent);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        long morningStartTimeMiles =1600862400*1000L;
            long morningEndStartTimeMiles=1600887600*1000L;

//        long eveningStartTimeMiles =System.currentTimeMillis()+(2*60*1000);
//        long eveningEndStartTimeMiles=morningStartTimeMiles+(2*60*60*1000);
//        CalendarProviderManager.startCalendarForIntentToInsert(this,morningStartTimeMiles,endStartTimeMiles,"this is title","this is desc","北京西北旺",false);

        CalendarEvent calendarMorningEvent=new CalendarEvent("this is morning title test","this is morning desc test","北京钻石大厦滴滴大厦morningtest",morningStartTimeMiles,morningEndStartTimeMiles,AdvanceTime.ZERO_MINUTES,null);
        CalendarProviderManager.addCalendarEvent(this,calendarMorningEvent);

//        CalendarEvent calendarEveningEvent=new CalendarEvent("this is evening title test","this is evening desc test","北京钻石大厦滴滴大厦eveningtest",eveningStartTimeMiles,eveningEndStartTimeMiles,AdvanceTime.ZERO_MINUTES,null);
//        CalendarProviderManager.addCalendarEvent(this,calendarEveningEvent);

//        Intent intent = new Intent();
//            intent.setComponent(new ComponentName("com.android.calendar",
//                    "com.android.calendar.LaunchActivity"));
//            startActivity(intent);

    }

    public void openWeekActivity(View view){
        Intent intent=new Intent(this, WeekShowActivity.class);
        startActivity(intent);
    }
}
