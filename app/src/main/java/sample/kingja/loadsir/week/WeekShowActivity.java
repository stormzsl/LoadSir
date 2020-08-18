package sample.kingja.loadsir.week;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import sample.kingja.loadsir.R;

/**
 * 作者:created by storm
 */

public class WeekShowActivity extends AppCompatActivity {

    private final static int COUNT = 10;

    private LinearLayout mWeekContainer;

    private WeekViewModel weekViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_show_activity);
        weekViewModel=new ViewModelProvider(this).get(WeekViewModel.class);
        weekViewModel.changeWeekItemBackground.observe(this, new Observer<WeekShowItemView>() {
            @Override
            public void onChanged(WeekShowItemView acceptItemView) {
                if(acceptItemView!=null){
                    updateWeekShowBackGround(acceptItemView);
                }
            }
        });
        mWeekContainer = findViewById(R.id.week_container);
        for (int index = 0; index < COUNT; index++) {
            WeekShowItemView itemView = new WeekShowItemView(this);
            mWeekContainer.addView(itemView);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) itemView.getLayoutParams();
            params.rightMargin = 70;
            params.gravity = Gravity.CENTER;
            itemView.setData("日期", "星期" + index,weekViewModel);
        }


    }

    public void updateWeekShowBackGround(WeekShowItemView acceptItemView) {
        for (int index = 0; index < mWeekContainer.getChildCount(); index++) {
            View child = mWeekContainer.getChildAt(index);
            if (child instanceof WeekShowItemView) {
                ((WeekShowItemView) child).setSelected(child == acceptItemView);
            }
        }
    }
}
