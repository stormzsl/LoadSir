package sample.kingja.loadsir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.didiglobal.android.advanced.AdvanceActivity;
import com.didiglobal.android.standed.StandedActivity;

import androidx.appcompat.app.AppCompatActivity;
import sample.kingja.loadsir.calendar.CalendarActivity;
import sample.kingja.loadsir.mmkv.MMKVActivity;
import sample.kingja.loadsir.rtl.RtlActivity;
import sample.kingja.loadsir.scroll.ScrollSmoothActivity;
import sample.kingja.loadsir.target.AnimateActivity;
import sample.kingja.loadsir.target.BestPracticesActivity;
import sample.kingja.loadsir.target.ConstraintLayoutActivity;
import sample.kingja.loadsir.target.ConvertorActivity;
import sample.kingja.loadsir.target.DefaultCallbackActivity;
import sample.kingja.loadsir.target.FragmentSingleActivity;
import sample.kingja.loadsir.target.KeepTitleActivity;
import sample.kingja.loadsir.target.KeepTitleFragmentActivity;
import sample.kingja.loadsir.target.MultiFragmentActivity;
import sample.kingja.loadsir.target.MultiFragmentWithViewPagerActivity;
import sample.kingja.loadsir.target.NormalActivity;
import sample.kingja.loadsir.target.PlaceholderActivity;
import sample.kingja.loadsir.target.ViewTargetActivity;

/**
 * Description:TODO
 * Create Time:2017/9/2 16:02
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void smoothScroll(View view) {
        startActivity(new Intent(this, ScrollSmoothActivity.class));
    }

    public void inActivity(View view) {
        startActivity(new Intent(this, NormalActivity.class));
    }

    public void showPlaceholder(View view) {
        startActivity(new Intent(this, PlaceholderActivity.class));
    }

    public void inActivityWithConvertor(View view) {
        startActivity(new Intent(this, ConvertorActivity.class));
    }

    public void inFragment(View view) {
        startActivity(new Intent(this, FragmentSingleActivity.class));
    }

    public void inFragmentMutil(View view) {
        startActivity(new Intent(this, MultiFragmentActivity.class));
    }

    public void inFragmentViewSirPager(View view) {
        startActivity(new Intent(this, MultiFragmentWithViewPagerActivity.class));
    }

    public void inView(View view) {
        startActivity(new Intent(this, ViewTargetActivity.class));
    }

    public void defaultCallback(View view) {
        startActivity(new Intent(this, DefaultCallbackActivity.class));
    }

    public void animatCallback(View view) {
        startActivity(new Intent(this, AnimateActivity.class));
    }

    public void keepTitleInFragment(View view) {
        startActivity(new Intent(this, KeepTitleFragmentActivity.class));
    }

    public void bestPractices(View view) {
        startActivity(new Intent(this, BestPracticesActivity.class));
    }

    public void keepTitleInActivity(View view) {
        startActivity(new Intent(this, KeepTitleActivity.class));
    }

    public void inConstraintLayoutActivity(View view) {
        startActivity(new Intent(this, ConstraintLayoutActivity.class));
    }

    //打开mmkv
    public void openMMKV(View view) {
        startActivity(new Intent(this, MMKVActivity.class));
    }

    //打开日历
    public void openCalendar(View view) {
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }

    public void rtlClick(View view) {
        Intent intent = new Intent(this, RtlActivity.class);
        startActivity(intent);
    }

    public void standClick(View view) {
        Intent intent = new Intent(this, StandedActivity.class);
        startActivity(intent);
    }

    public void advanceClick(View view) {
        Intent intent = new Intent(this, AdvanceActivity.class);
        startActivity(intent);
    }
}
