package sample.kingja.loadsir.week;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import sample.kingja.loadsir.R;

/**
 * 作者:created by storm
 */

public class WeekShowItemView extends LinearLayout implements View.OnClickListener {

    private TextView mTitleTv;

    private TextView mSubTitleTv;

    private Context mContext;

    public WeekShowItemView(Context context) {
        super(context);
        init(context);
    }

    public WeekShowItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public WeekShowItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public WeekShowItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mContext=context;
        setOrientation(VERTICAL);
        LayoutInflater.from(context).inflate(R.layout.week_show_item_layout, this, true);
        mTitleTv = findViewById(R.id.week_title_tv);
        mSubTitleTv = findViewById(R.id.week_subtitle_tv);
        setOnClickListener(this::onClick);
    }

    public void setData(String title, String subTitle) {
        mTitleTv.setText(title);
        mSubTitleTv.setText(subTitle);
    }

    @Override
    public void onClick(View v) {
        Log.e("stormzsl", "aaa");
        if(mContext instanceof WeekShowActivity){
            ((WeekShowActivity) mContext).updateWeekShowBackGround(this);
        }
    }

    public void clearBackgroundDrawable(){
        setBackground(null);
    }

    public void setBackgroundShape(){
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(5);
        drawable.setStroke(1, Color.parseColor("#cccccc"));
        drawable.setColor(Color.parseColor("#eeeeee"));
        setBackground(drawable);
    }
}
