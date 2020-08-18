package sample.kingja.loadsir.week;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import sample.kingja.loadsir.R;

/**
 * 作者:created by storm
 */

public class WeekShowActivity extends AppCompatActivity {

    private final static int COUNT = 10;

    private LinearLayout mWeekContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_show_activity);
        mWeekContainer = findViewById(R.id.week_container);

        for (int index = 0; index < COUNT; index++) {
            WeekShowItemView itemView = new WeekShowItemView(this);
            mWeekContainer.addView(itemView);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) itemView.getLayoutParams();
            params.rightMargin = 70;
            params.gravity = Gravity.CENTER;
            itemView.setData("日期", "星期" + index);
        }
    }

    public void updateWeekShowBackGround(WeekShowItemView acceptItemView) {
        for (int index = 0; index < mWeekContainer.getChildCount(); index++) {
            View child = mWeekContainer.getChildAt(index);
            if (child instanceof WeekShowItemView) {
                if (child == acceptItemView) {
                    ((WeekShowItemView) child).setBackgroundShape();
                } else {
                    child.setBackground(null);
                }
            }
        }
    }
}
